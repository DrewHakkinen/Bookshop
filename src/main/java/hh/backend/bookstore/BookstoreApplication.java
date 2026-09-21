package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Luodaan testidataa tietokantaan
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("Keitto kirja", "Kape Aihinen", 2016, 845649364456L, 24.50);
			bookRepository.save(book1); // SQL INSERT
			Book book2 = new Book("Aleksei Navalnyin elämänkerta", "Kalle Kniivilä", 2024, 3289649234L, 16.90);
			bookRepository.save(book2); // SQL INSERT
			Book book3 = new Book("Uusi Autokirja", "O. Pohjanen ja A. I. Walli", 1950, 849653479582L, 18.00);
			bookRepository.save(book3); // SQL INSERT
		};
	}

	@Bean
	public CommandLineRunner democategory(CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category("Tietokirjallisuus");
			categoryRepository.save(category1);
			Category category2 = new Category("Kaunokirjallisuus");
			categoryRepository.save(category2);
			Category category3 = new Category("Kauhukirjallisuus");
			categoryRepository.save(category3);
		};
	}
}
