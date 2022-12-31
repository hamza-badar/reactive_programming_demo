package com.rp.sec02;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.onNext;

public class Lec05FluxWithRange {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(10, 10);
        flux.subscribe(onNext());

        Flux<String> stringFlux = Flux.range(1, 10).log().map(ele -> faker().name().fullName()).log();
        stringFlux.log().subscribe(onNext());
    }
}
