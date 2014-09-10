package io.pivotal.cf.demo.springbox.repositories;

import io.pivotal.cf.demo.springbox.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "genres", path = "genres")
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
