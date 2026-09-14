package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// Luodaan testidataa tietokantaan
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("Keitto kirja", "Kape Aihinen", 2016, 24.50);
			bookRepository.save(book1); // SQL INSERT
			Book book2 = new Book("Aleksei Navalnyi", "Kalle Kniivilä", 2024, 16.90);
			bookRepository.save(book2); // SQL INSERT
			Book book3 = new Book("Uusi Autokirja", "O. Pohjanen ja A. I. Walli", 1950, 18.00);
			bookRepository.save(book3); // SQL INSERT
		};
	}
}
