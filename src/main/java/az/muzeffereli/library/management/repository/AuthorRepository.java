package az.muzeffereli.library.management.repository;

import az.muzeffereli.library.management.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
