package pl.sda.libraryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.libraryproject.model.Author;
import pl.sda.libraryproject.model.Book;
import pl.sda.libraryproject.model.BooksType;
import pl.sda.libraryproject.repository.AuthorRepository;
import pl.sda.libraryproject.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Book book) {
        Optional<Author> author = authorRepository.findById(book.getAuthorId());
        author.ifPresent(a -> book.setAuthor(a));
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<String> findAllCategories() {
        return Arrays.stream(BooksType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
