package guru.springframework.springwebapp.repository;

import guru.springframework.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository< Author, Long > {
}
