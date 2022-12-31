package com.rp.sec04;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec06OnError {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> i/(5-i))
                //.onErrorReturn(-1)
                //.onErrorResume(err -> fallback())
                .onErrorContinue((err, object) -> {})
                .subscribe(subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(()-> faker().random().nextInt(100,150));
    }
}
