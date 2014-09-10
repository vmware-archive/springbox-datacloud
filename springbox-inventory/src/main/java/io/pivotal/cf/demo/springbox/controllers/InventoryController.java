package io.pivotal.cf.demo.springbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    public static final String KIOSK_KEY_PREFIX = "kiosk:";
    public static final String MOVIE_KEY_PREFIX = "movie:";
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/inventory/location/{locationId}/movie/{movieId}")
    public ResponseEntity<String> inStockFor(@PathVariable("locationId") String locationId, @PathVariable("movieId") String movieId) {

        final String kioskKey = KIOSK_KEY_PREFIX + locationId;
        final String movieKey = MOVIE_KEY_PREFIX + movieId;

        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        String count = hashOps.get(kioskKey, movieKey);

        return new ResponseEntity<>("{\"numberInStock\":" + count + "}", HttpStatus.OK);
    }
}
