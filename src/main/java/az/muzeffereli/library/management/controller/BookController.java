package az.muzeffereli.library.management.controller;


import az.muzeffereli.library.management.dto.BookRequestDto;
import az.muzeffereli.library.management.dto.BookResponseDto;
import az.muzeffereli.library.management.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PostMapping
    public void save(@RequestBody BookRequestDto bookRequestDTO) {
        bookService.save(bookRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById( @PathVariable long id) {
        bookService.deleteById(id);
    }
}
