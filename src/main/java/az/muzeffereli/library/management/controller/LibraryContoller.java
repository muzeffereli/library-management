package az.muzeffereli.library.management.controller;


import az.muzeffereli.library.management.dto.LibraryRequestDto;
import az.muzeffereli.library.management.dto.LibraryResponseDto;
import az.muzeffereli.library.management.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
@RequiredArgsConstructor
public class LibraryContoller {
    private final LibraryService libraryService;

    @GetMapping("/{id}")
    public ResponseEntity<LibraryResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryResponseDto>> getAll() {
        return ResponseEntity.ok(libraryService.getAll());
    }

    @PostMapping
    public void save(@RequestBody LibraryRequestDto libraryRequestDTO) {
        libraryService.save(libraryRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById( @PathVariable long id) {
        libraryService.deleteById(id);
    }
}
