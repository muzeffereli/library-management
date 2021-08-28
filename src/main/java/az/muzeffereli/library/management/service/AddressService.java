package az.muzeffereli.library.management.service;

import az.muzeffereli.library.management.dto.AddressRequestDto;
import az.muzeffereli.library.management.dto.AddressResponseDto;

import java.util.List;

public interface AddressService {
    List<AddressResponseDto> getAll();

    AddressResponseDto getById(Long id);

    void save(AddressRequestDto addressRequestDTO);

    void deleteById(Long id);
}
