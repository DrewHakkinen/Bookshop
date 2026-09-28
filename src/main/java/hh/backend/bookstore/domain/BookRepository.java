package hh.backend.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    // CRUDRepositorypalveluista periytyy save, findAll, findId ja deleteById
    List<Book> findByTitle(String title);
}
