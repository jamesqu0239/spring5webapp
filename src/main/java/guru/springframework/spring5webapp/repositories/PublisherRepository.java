package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.pojo.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
