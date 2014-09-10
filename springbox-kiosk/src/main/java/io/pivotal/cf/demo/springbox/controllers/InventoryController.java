package io.pivotal.cf.demo.springbox.controllers;

import io.pivotal.cf.demo.springbox.events.DropOffEvent;
import io.pivotal.cf.demo.springbox.events.PickUpEvent;
import io.pivotal.cf.demo.springbox.gateways.InventoryGateway;
import io.pivotal.cf.demo.springbox.model.Genre;
import io.pivotal.cf.demo.springbox.model.Movie;
import io.pivotal.cf.demo.springbox.model.Reservation;
import io.pivotal.cf.demo.springbox.repositories.MovieRepository;
import io.pivotal.cf.demo.springbox.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    @Value("${LOCATION_ID}")
    private Long locationId;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private InventoryGateway inventoryGateway;

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(value = "/inventory/dropOff/{movieId}", method = RequestMethod.PUT)
    public ResponseEntity<String> dropOff(@PathVariable("movieId") Long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        int numberInStock = movie.getNumberInStock();
        numberInStock++;
        movie.setNumberInStock(numberInStock);
        movieRepository.save(movie);

        inventoryGateway.sendDropOffEvent(new DropOffEvent(movie.getId(), extractGenreIds(movie), locationId));

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @RequestMapping(value = "/reservation/pickUp/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> pickUp(@PathVariable("customerId") String customerId) {
        final List<Reservation> reservations = reservationRepository.findByCustomerId(customerId);

        for (Reservation reservation : reservations) {
            Movie movie = reservation.getMovie();
            inventoryGateway.sendPickUpEvent(new PickUpEvent(movie.getId(), extractGenreIds(movie), locationId));
            reservationRepository.delete(reservation);
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    private List<String> extractGenreIds(Movie movie) {
        ArrayList<String> genreIds = new ArrayList<>();
        for (Genre genre : movie.getGenres()) {
            genreIds.add(genre.getMlId());
        }
        return genreIds;
    }
}
