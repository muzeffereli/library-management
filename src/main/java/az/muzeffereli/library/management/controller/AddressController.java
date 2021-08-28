package az.muzeffereli.library.management.controller;

import az.muzeffereli.library.management.dto.AddressRequestDto;
import az.muzeffereli.library.management.dto.AddressResponseDto;
import az.muzeffereli.library.management.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressResponseDto>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @PostMapping
    public void save(@RequestBody AddressRequestDto addressRequestDto){
        addressService.save(addressRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById( @PathVariable long id) {
        addressService.deleteById(id);
    }

}
