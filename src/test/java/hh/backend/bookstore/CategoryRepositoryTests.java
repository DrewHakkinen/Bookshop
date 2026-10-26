package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Tietokirjallisuus");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Tietokirjallisuus");
    }

    @Test
    public void CreateNewCategory() {
        Category category = new Category("Iso-Don");
        categoryRepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void DeleteCategory() {
        Category category = new Category("Iso-Don");
        categoryRepository.save(category);

        categoryRepository.delete(category);

        assertThat(categoryRepository.findByName("Iso-Don")).isEmpty();

    }
}
