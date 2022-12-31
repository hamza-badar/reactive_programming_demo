package com.rp.sec04;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.rp.courseutil.Util.subscriber;

public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers().filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(subscriber());
    }
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10);
    }
}
