package pl.sda.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.libraryproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
