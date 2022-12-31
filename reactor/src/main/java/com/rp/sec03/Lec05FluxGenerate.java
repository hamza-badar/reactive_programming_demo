package com.rp.sec03;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        //using synchronoussink we can emit only 1 time
        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
           synchronousSink.next(faker().country().name());
           //synchronousSink.complete();
           //synchronousSink.error(new RuntimeException("oops"));
           //synchronousSink.next(faker().country().name());
        }).take(3)
                .subscribe(subscriber());
    }
}
