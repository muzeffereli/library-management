package az.muzeffereli.library.management.service.impl;

import az.muzeffereli.library.management.dao.entity.Author;
import az.muzeffereli.library.management.dao.entity.Book;
import az.muzeffereli.library.management.dao.entity.Library;
import az.muzeffereli.library.management.dto.BookRequestDto;
import az.muzeffereli.library.management.dto.BookResponseDto;
import az.muzeffereli.library.management.repository.AuthorRepository;
import az.muzeffereli.library.management.repository.BookRepository;
import az.muzeffereli.library.management.repository.LibraryRepository;
import az.muzeffereli.library.management.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    private final AuthorRepository authorRepository;

    public List<BookResponseDto> getAll() {
        List<BookResponseDto> bookResponseDTOS = new ArrayList<>();

        bookRepository.findAll().forEach(
                book -> bookResponseDTOS.add(
                        new BookResponseDto(book)));

        return bookResponseDTOS;
    }

    @Override
    public BookResponseDto getById(Long id) {
        return new BookResponseDto(
                bookRepository.getById(id));
    }


    @Transactional
    @Override
    public void save(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());

        List<Author> authors = new ArrayList<>();

        for (Long id : bookRequestDto.getAuthorIds())
            authors.add(authorRepository.findById(id).get());

        for (Author author : authors)
            author.getBooks().add(book);

        Library library = libraryRepository.findById(
                bookRequestDto.getLibraryId()).get();
        library.getBooks().add(book);
        book.setLibrary(library);

        book.setAuthors(authors);
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
