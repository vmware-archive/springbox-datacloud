package io.pivotal.cf.demo.springbox.events;

import java.util.List;

/**
 * Created by pivotal on 9/10/14.
 */
public class RentEvent {

    private Long movieId;
    private List<String> genreIds;
    private Long locationId;

    public RentEvent(Long movieId, List<String> genreIds, Long locationId) {
        this.movieId = movieId;
        this.genreIds = genreIds;
        this.locationId = locationId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public List<String> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<String> genreIds) {
        this.genreIds = genreIds;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
