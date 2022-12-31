package com.rp.sec02;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.rp.courseutil.Util.onNext;
import static com.rp.courseutil.Util.sleepSeconds;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(onNext());
        sleepSeconds(5);
    }
}
