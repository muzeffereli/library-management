package az.muzeffereli.library.management.dto;

import az.muzeffereli.library.management.dao.entity.Library;
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
public class LibraryResponseDto {
    private String name;
    private String location;
    private List<String> books = new ArrayList<>();

    public LibraryResponseDto(Library library) {
        this.name = library.getName();
        this.location = library.getAddress().getLocation();
        library.getBooks()
                .forEach(book ->
                        books.add(book.getTitle()));
    }
}
