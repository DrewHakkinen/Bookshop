package hh.backend.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

    // attribuutit
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // db uusi id arvo generoituu uudelle tietoriville
    private Long bookId;

    private String title;
    private String author;
    private int publicationYear;
    private Long isbn;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    // konstruktorit
    public Book(String title, String author, int publicationYear,
            Long isbn, double price) {
        super();
        this.bookId = null;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
        super();
        this.bookId = null;
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = null;
        this.price = 0.00;
    }

    // getterit

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Long getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    // setterit

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publicationYear="
                + publicationYear + ", isbn=" + isbn + ", price=" + price + "]";
    }
}
