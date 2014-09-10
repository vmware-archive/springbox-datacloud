package io.pivotal.cf.demo.springbox.events;

public class ReservationEvent {

    private String customerId;
    private String movieId;
    private String locationId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
