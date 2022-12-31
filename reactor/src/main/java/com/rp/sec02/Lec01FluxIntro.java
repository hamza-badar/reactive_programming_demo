package com.rp.sec02;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.*;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        flux.subscribe(onNext(),
                onError(),
                onComplete());

    }
}
