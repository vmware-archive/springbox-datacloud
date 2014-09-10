package io.pivotal.cf.demo.springbox.eventhandlers;

import io.pivotal.cf.demo.springbox.events.ReservationEvent;
import io.pivotal.cf.demo.springbox.model.Movie;
import io.pivotal.cf.demo.springbox.model.Reservation;
import io.pivotal.cf.demo.springbox.repositories.MovieRepository;
import io.pivotal.cf.demo.springbox.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationEventHandler {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void handleReservationEvent(ReservationEvent event) {
        Movie movie = movieRepository.findOne(new Long(event.getMovieId()));

        int numberInStock = movie.getNumberInStock();
        numberInStock--;
        movie.setNumberInStock(numberInStock);

        movieRepository.save(movie);

        Reservation reservation = new Reservation();
        reservation.setCustomerId(event.getCustomerId());
        reservation.setMovie(movie);

        reservationRepository.save(reservation);
    }
}
