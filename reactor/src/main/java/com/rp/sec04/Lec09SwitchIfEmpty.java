package com.rp.sec04;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers().filter(i -> i > 10)
                //.switchIfEmpty(fallback1())
                .switchIfEmpty(fallback2())
                .subscribe(subscriber());
    }
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10);
    }

    private static Flux<Integer> fallback1() {
        return Flux.range(11,10);
    }

    private static Mono<Integer> fallback2() {
        return Mono.fromSupplier(() -> faker().random().nextInt(11,20));
    }
}
