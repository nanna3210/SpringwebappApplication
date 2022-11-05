package guru.springframework.springwebapp.repository;

import guru.springframework.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository< Publisher , Long  > {

}
