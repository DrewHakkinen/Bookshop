package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/index")
    public String getBooks(Model model) {

        return "index"; // index.html
    }

}
