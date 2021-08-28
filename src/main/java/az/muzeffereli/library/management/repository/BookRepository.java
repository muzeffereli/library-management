package az.muzeffereli.library.management.repository;

import az.muzeffereli.library.management.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
