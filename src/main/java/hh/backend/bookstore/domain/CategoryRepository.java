package hh.backend.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    // CRUDRepositorypalveluista periytyy save, findAll, findId ja deleteById

}
