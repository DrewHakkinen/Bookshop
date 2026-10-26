package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("Keittokirja");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Kape Aihinen");
    }

    @Test
    public void CreateNewBook() {
        Book book = new Book("Oravien suuri kirja", "Pikku-Tom", 2026, null, 24.50, null);
        bookRepository.save(book);

        assertThat(book.getBookId()).isNotNull();
    }

    @Test
    public void DeleteaBook() {

        Book book = new Book("Oravien suuri kirja", "Pikku-Tom", 2026, null, 24.50, null);
        bookRepository.save(book);

        bookRepository.delete(book);

        assertThat(bookRepository.findByTitle("Oravien suuri kirja")).isEmpty();
    }

}
