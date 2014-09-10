package io.pivotal.cf.demo.springbox.events;

public class PickUpEvent {

    private Long movieId;
    private Long genreId;
    private Long locationId;

    public PickUpEvent(Long movieId, Long genreId, Long locationId) {
        this.movieId = movieId;
        this.genreId = genreId;
        this.locationId = locationId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
