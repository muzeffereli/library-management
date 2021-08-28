package az.muzeffereli.library.management.dto;

import az.muzeffereli.library.management.dao.entity.Author;
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
public class AuthorResponseDto {
    private String name;
    private List<String> books = new ArrayList<>();

    public AuthorResponseDto(Author author) {
        this.name = author.getName();
        author.getBooks()
                .forEach(book ->
                        books.add(book.getTitle()));
    }
}
