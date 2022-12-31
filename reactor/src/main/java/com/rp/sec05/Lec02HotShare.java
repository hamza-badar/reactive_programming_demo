package com.rp.sec05;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec02HotShare {
    public static void main(String[] args) {
        //share = publis().refCOunt(1)
        Flux<String> movieStream = Flux.fromStream(Lec02HotShare::getMovie).delayElements(Duration.ofSeconds(2)).share();

        movieStream.subscribe(subscriber("sam"));
        sleepSeconds(5);
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
