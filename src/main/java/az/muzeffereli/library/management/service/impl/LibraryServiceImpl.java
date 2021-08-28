package az.muzeffereli.library.management.service.impl;

import az.muzeffereli.library.management.dao.entity.Library;
import az.muzeffereli.library.management.dto.LibraryRequestDto;
import az.muzeffereli.library.management.dto.LibraryResponseDto;
import az.muzeffereli.library.management.repository.AddressRepository;
import az.muzeffereli.library.management.repository.LibraryRepository;
import az.muzeffereli.library.management.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;
    private final AddressRepository addressRepository;

    public List<LibraryResponseDto> getAll() {
        List<LibraryResponseDto> libraryResponseDTOS = new ArrayList<>();

        libraryRepository.findAll().forEach(
                library -> libraryResponseDTOS.add(
                        new LibraryResponseDto(library)));

        return libraryResponseDTOS;
    }

    @Override
    public LibraryResponseDto getById(Long id) {
        return new LibraryResponseDto(
                libraryRepository.getById(id));
    }

    @Override
    public void save(LibraryRequestDto libraryRequestDTO) {
        Library library = new Library();
        library.setName(libraryRequestDTO.getName());
        library.setAddress(
                addressRepository.findById(
                        libraryRequestDTO.getAddressId()).get());

        libraryRepository.save(
                library
        );
    }

    @Override
    public void deleteById(Long id) {
        libraryRepository.deleteById(id);
    }
}
