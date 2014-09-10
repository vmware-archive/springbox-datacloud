package io.pivotal.cf.demo.springbox.repositories;

import io.pivotal.cf.demo.springbox.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
