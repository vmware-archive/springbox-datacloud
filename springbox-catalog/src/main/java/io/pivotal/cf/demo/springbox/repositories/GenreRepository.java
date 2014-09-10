package io.pivotal.cf.demo.springbox.repositories;

import io.pivotal.cf.demo.springbox.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "genres", path = "genres")
public interface GenreRepository extends MongoRepository<Genre, String> {

    List<Genre> findByName(String name);
}
