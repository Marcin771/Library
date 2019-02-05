package pl.sda.libraryproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.libraryproject.model.Author;
import pl.sda.libraryproject.model.Book;
import pl.sda.libraryproject.service.IAuthorService;
import pl.sda.libraryproject.service.IBookService;

import java.util.List;

@Controller
public class BookController {

    private IBookService bookService;
    private IAuthorService authorService;

    @Autowired
    public BookController(IBookService bookService, IAuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String listBookView(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

    @PostMapping("book/delete")
    public String doAction(@RequestParam Long bookId) {
        bookService.delete(bookId);
        return "redirect:/";
    }

    @GetMapping("book/add/view")
    public String addBookView(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute( "categories", bookService.findAllCategories());
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("book/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/";
    }
}
