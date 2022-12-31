package com.rp.sec04;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec07Timeout {
    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallBack())
                .subscribe(subscriber());

        sleepSeconds(60);
    }
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10).delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallBack() {
        return Flux.range(1,10).delayElements(Duration.ofSeconds(2));
    }
}
