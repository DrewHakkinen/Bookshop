package hh.backend.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    // CRUDRepositorypalveluista periytyy save, findAll, findId ja deleteById
}
