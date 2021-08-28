package az.muzeffereli.library.management.service;

import az.muzeffereli.library.management.dto.LibraryRequestDto;
import az.muzeffereli.library.management.dto.LibraryResponseDto;

import java.util.List;

public interface LibraryService {
    List<LibraryResponseDto> getAll();

    LibraryResponseDto getById(Long id);

    void save(LibraryRequestDto libraryRequestDto);

    void deleteById(Long id);
}
