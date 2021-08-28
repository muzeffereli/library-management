package az.muzeffereli.library.management.repository;

import az.muzeffereli.library.management.dao.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
