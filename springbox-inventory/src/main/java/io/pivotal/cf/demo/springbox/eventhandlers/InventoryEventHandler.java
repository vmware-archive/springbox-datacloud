package io.pivotal.cf.demo.springbox.eventhandlers;

import io.pivotal.cf.demo.springbox.events.DropOffEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventHandler {

    public static final String KIOSK_KEY_PREFIX = "kiosk:";
    public static final String MOVIE_KEY_PREFIX = "movie:";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public void handleDropOffEvent(DropOffEvent event) {

        final String kioskKey = KIOSK_KEY_PREFIX + event.getLocationId();
        final String movieKey = MOVIE_KEY_PREFIX + event.getMovieId();

        final BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(kioskKey);
        hashOps.increment(movieKey, 1);
    }
}
