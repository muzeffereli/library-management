package az.muzeffereli.library.management.service;

import az.muzeffereli.library.management.dto.AuthorRequestDto;
import az.muzeffereli.library.management.dto.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    List<AuthorResponseDto> getAll();

    AuthorResponseDto getById(Long id);

    void save(AuthorRequestDto authorRequestDto);

    void deleteById(Long id);
}
