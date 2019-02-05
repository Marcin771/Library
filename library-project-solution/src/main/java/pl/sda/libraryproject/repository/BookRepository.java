package pl.sda.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.libraryproject.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
