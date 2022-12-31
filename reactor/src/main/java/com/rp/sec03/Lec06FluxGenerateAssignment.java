package com.rp.sec03;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            synchronousSink.next(faker().country().name());
        }).takeUntil(country -> {
            String countryName = (String) country;
            return countryName.equalsIgnoreCase("canada");
        }).take(10)
                .subscribe(subscriber());
    }
}
