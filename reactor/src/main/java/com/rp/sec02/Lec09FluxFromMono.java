package com.rp.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.onNext;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(onNext());


        //converting flux to mono
        Flux.range(1,10)
                .filter(i -> i == 5)
                .next()
                .subscribe(onNext());

    }
}
