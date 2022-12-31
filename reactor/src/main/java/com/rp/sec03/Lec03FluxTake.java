package com.rp.sec03;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.subscriber;

public class Lec03FluxTake {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .take(3)
                .log()
                .subscribe(subscriber());
    }
}
