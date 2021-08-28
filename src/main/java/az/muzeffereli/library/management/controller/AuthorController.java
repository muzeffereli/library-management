package az.muzeffereli.library.management.controller;

import az.muzeffereli.library.management.dto.AuthorRequestDto;
import az.muzeffereli.library.management.dto.AuthorResponseDto;
import az.muzeffereli.library.management.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @PostMapping
    public void save(@RequestBody AuthorRequestDto authorRequestDTO) {
        authorService.save(authorRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById( @PathVariable long id) {
        authorService.deleteById(id);
    }
}
