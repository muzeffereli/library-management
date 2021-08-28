package az.muzeffereli.library.management.service;

import az.muzeffereli.library.management.dto.BookRequestDto;
import az.muzeffereli.library.management.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAll();

    BookResponseDto getById(Long id);

    void save(BookRequestDto bookRequestDTO);

    void deleteById(Long id);
}
