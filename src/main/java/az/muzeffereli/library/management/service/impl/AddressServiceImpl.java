package az.muzeffereli.library.management.service.impl;

import az.muzeffereli.library.management.dao.entity.Address;
import az.muzeffereli.library.management.dto.AddressRequestDto;
import az.muzeffereli.library.management.dto.AddressResponseDto;
import az.muzeffereli.library.management.repository.AddressRepository;
import az.muzeffereli.library.management.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<AddressResponseDto> getAll() {
        List<AddressResponseDto> addressResponseDtos = new ArrayList<>();

        addressRepository.findAll().forEach(address -> addressResponseDtos.add(
                new AddressResponseDto(address)
        ));

        return addressResponseDtos;
    }

    @Override
    public AddressResponseDto getById(Long id) {
        return new AddressResponseDto(addressRepository.getById(id));
    }

    @Override
    public void save(AddressRequestDto addressRequestDTO) {
        Address address = new Address();
        address.setLocation(addressRequestDTO.getLocation());

        addressRepository.save(
                address
        );
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
