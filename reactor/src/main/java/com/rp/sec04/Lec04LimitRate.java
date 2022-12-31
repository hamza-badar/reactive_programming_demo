package com.rp.sec04;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.subscriber;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100)
                .subscribe(subscriber());

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 97)
                .subscribe(subscriber());

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 0)
                .subscribe(subscriber());
    }
}
