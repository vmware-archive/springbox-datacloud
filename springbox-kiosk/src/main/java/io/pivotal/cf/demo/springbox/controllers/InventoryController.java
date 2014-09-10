package io.pivotal.cf.demo.springbox.controllers;

import io.pivotal.cf.demo.springbox.events.DropOffEvent;
import io.pivotal.cf.demo.springbox.gateways.InventoryGateway;
import io.pivotal.cf.demo.springbox.model.Movie;
import io.pivotal.cf.demo.springbox.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Value("${LOCATION_ID}")
    private Long locationId;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private InventoryGateway inventoryGateway;

    @RequestMapping(value = "/inventory/dropOff/{movieId}", method = RequestMethod.PUT)
    public ResponseEntity<String> dropOff(@PathVariable("movieId") Long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        int numberInStock = movie.getNumberInStock();
        numberInStock++;
        movie.setNumberInStock(numberInStock);
        movieRepository.save(movie);

        inventoryGateway.sendDropOffEvent(new DropOffEvent(movie.getId(), movie.getGenre().getId(), locationId));

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
