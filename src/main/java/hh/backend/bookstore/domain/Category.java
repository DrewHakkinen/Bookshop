package hh.backend.bookstore.domain;

//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;

@Entity
public class Category {

    // attribuutit
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;

    private String name;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    // private List<Book> books;

    // konstruktorit
    public Category(String name) {
        super();
        this.name = name;
    }

    public Category() {
    }

    // Getterit
    public Long getCategoryid() {
        return categoryid;
    }

    public String getName() {
        return name;
    }

    // Setterit
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }
}
