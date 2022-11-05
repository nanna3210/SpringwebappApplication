package guru.springframework.springwebapp.repository;

import guru.springframework.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository< Book, Long > {
}
