package io.pivotal.cf.demo.springbox.events;

import java.util.List;

public class DropOffEvent {

    private Long movieId;
    private List<String> genreIds;
    private Long locationId;

    public DropOffEvent(Long movieId, List<String> genreIds, Long locationId) {
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

    public void setGenreIds(List<String> genreId) {
        this.genreIds = genreIds;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "DropOffEvent{" +
                "movieId=" + movieId +
                ", genreIds=" + genreIds +
                ", locationId=" + locationId +
                '}';
    }
}
