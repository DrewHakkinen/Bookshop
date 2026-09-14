package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.backend.bookstore.domain.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    // konstruktori injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    public String getBooks(Model model) {

        return "index"; // index.html
    }

    // kirjalistaus
    @GetMapping("/booklist")
    public String showBooks(Model model) {

        // haetaan kirjat tietokannasta findAll -> SQL SELECT
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // booklist.html
    }

}
