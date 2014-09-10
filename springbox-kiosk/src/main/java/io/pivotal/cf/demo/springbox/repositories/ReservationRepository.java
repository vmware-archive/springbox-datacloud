package io.pivotal.cf.demo.springbox.repositories;

import io.pivotal.cf.demo.springbox.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "reservations", path = "reservations")
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByCustomerId(String customerId);
}
