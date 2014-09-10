package io.pivotal.cf.demo.springbox.repositories;

import io.pivotal.cf.demo.springbox.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends MongoRepository<Movie, String> {
}
