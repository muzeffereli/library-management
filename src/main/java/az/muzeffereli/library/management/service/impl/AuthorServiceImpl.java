package az.muzeffereli.library.management.service.impl;

import az.muzeffereli.library.management.dao.entity.Author;
import az.muzeffereli.library.management.dao.entity.Book;
import az.muzeffereli.library.management.dto.AuthorRequestDto;
import az.muzeffereli.library.management.dto.AuthorResponseDto;
import az.muzeffereli.library.management.repository.AuthorRepository;
import az.muzeffereli.library.management.repository.BookRepository;
import az.muzeffereli.library.management.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public List<AuthorResponseDto> getAll() {
        List<AuthorResponseDto> authorResponseDTOS = new ArrayList<>();

        authorRepository.findAll().forEach(
                author -> authorResponseDTOS.add(
                        new AuthorResponseDto(author)));

        return authorResponseDTOS;
    }

    @Override
    public AuthorResponseDto getById(Long id) {
        return new AuthorResponseDto(
                authorRepository.getById(id));
    }

    @Override
    public void save(AuthorRequestDto authorRequestDto) {
        Author author = new Author();

        author.setName(authorRequestDto.getName());

        List<Book> books = new ArrayList<>();

        if(authorRequestDto.getBookIds() != null){
            for (Long id:authorRequestDto.getBookIds()) {
                books.add(bookRepository.findById(id).get());
            }

            for(Book book: books)
                book.getAuthors().add(author);

        }

        author.setBooks(books);
        authorRepository.save(author);


    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
