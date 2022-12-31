package com.rp.sec05;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec05HotPublishCache {
    public static void main(String[] args) {
        //cache = publish().replay()
        Flux<String> movieStream = Flux.fromStream(Lec05HotPublishCache::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .cache(2);

        sleepSeconds(3);
        movieStream.subscribe(subscriber("sam"));
        sleepSeconds(12);
        movieStream.subscribe(subscriber("mike"));
        sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of("Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8",
                "Scene 9",
                "Scene 10");
    }
}
