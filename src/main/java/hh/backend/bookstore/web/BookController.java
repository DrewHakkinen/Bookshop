package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    // konstruktori injection
    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/index")
    public String getBooks(Model model) {

        return "index"; // index.html
    }

    // kirjalistaus
    @GetMapping("/booklisting")
    public String showBooks(Model model) {

        // haetaan kirjat tietokannasta findAll -> SQL SELECT
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // booklist.html
    }

    // tyhjän kirjalomakkeen muodostaminen
    @GetMapping(value = "/newbook")
    public String getNewBookForm(Model model) {
        model.addAttribute("book", new Book()); // "tyhjä" kirja-olio
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }

    // kirjalomakeella syötettyjen tietojen vastaanotto ja tallennus
    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book, Model model) {
        // ei osata vielä tallentaa tietokantaan lomakkeelta syötetyn auton tietoja
        bookRepository.save(book); // SQL INSERT
        return "redirect:/booklisting"; // endpoint
    }

    // Kirjan poisto
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {

        bookRepository.deleteById(bookId); // SQL DELETE
        return "redirect:/booklisting"; // endpoint

    }

    // kirjan editointi
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {

        model.addAttribute("book", bookRepository.findById(bookId).get());
        return "editbook"; // editbook.html
    }
}
