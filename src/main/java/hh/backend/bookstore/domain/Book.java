package hh.backend.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

    // attribuutit
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // db uusi id arvo generoituu uudelle tietoriville
    private String title;
    private String author;
    private int publicationYear;
    private Long isbnId;
    private double price;

    // konstruktorit
    public Book(String title, String author, int publicationYear,
            double price) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbnId = null;
        this.price = price;
    }

    public Book() {
        super();
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbnId = null;
        this.price = 0.00;
    }

    // getterit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Long getIsbnId() {
        return isbnId;
    }

    public double getPrice() {
        return price;
    }

    // setterit
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbnId(Long isbnId) {
        this.isbnId = isbnId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author +
                ", publicationYear=" + publicationYear + ", isbnId=" + isbnId
                + ", price=" + price + "]";
    }
}
