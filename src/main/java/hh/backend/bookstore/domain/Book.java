package hh.backend.bookstore.domain;

public class Book {

    // attribuutit
    private String title;
    private String author;
    private Long publicationYear;
    private Long isbn;
    private double price;

    // konstruktorit
    public Book(String title, String author, Long publicationYear,
            Long isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = null;
        this.isbn = null;
        this.price = 0.00;
    }

    // getterit
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getPublicationYear() {
        return publicationYear;
    }

    public Long getIsbn() {
        return isbn;
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

    public void setPublicationYear(Long publicationYear) {
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
        return "Book [title=" + title + ", author=" + author +
                ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }
}
