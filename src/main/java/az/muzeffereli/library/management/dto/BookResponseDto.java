package az.muzeffereli.library.management.dto;

import az.muzeffereli.library.management.dao.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private String title;
    private String library;
    private List<String> authors = new ArrayList<>();

    public BookResponseDto(Book book) {
        this.title = book.getTitle();
        this.library = book.getLibrary().getName();
        book.getAuthors()
                .forEach(author ->
                        authors.add(author.getName()));
    }
}
