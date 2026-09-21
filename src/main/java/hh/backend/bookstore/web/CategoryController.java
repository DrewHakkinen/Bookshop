package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    // konstruktori injection
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("categorylist")
    public String showCategories(Model model) {

        // Haetaan kategoriat tietokannasta
        model.addAttribute("categories", categoryRepository.findAll());

        return "categorylist"; // categorylist.html
    }

    // Tyhjän lomakkeen muodostaminen
    @GetMapping("/newcategory")
    public String getNewcategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    // lomakkeella syötettyjen tietojen vastaanotto ja tallentaminen
    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category, Model model) {
        categoryRepository.save(category);
        return "redirect:/categorylist"; // endpoint
    }

}
