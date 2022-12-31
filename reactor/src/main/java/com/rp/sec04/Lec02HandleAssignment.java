package com.rp.sec04;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec02HandleAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(faker().country().name()))
                .map(Object::toString)
                .handle((country, synchronousSink) -> {
                    if(country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    } else {
                        synchronousSink.next(country);
                    }
                }).subscribe(subscriber());
    }
}
