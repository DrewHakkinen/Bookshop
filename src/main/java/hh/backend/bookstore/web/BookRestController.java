package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class BookRestController {

    private BookRepository bookRepository;

    // konstruktori injection
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // RESTful service getting all books
    // Muunnetaan JSON-kirjalistaksi
    // lähetetään web-selaimelle vastauksena
    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service book by id
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }
}
