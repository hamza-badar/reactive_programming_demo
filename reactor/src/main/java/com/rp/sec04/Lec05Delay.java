package com.rp.sec04;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec05Delay {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "9");
        Flux.range(1,100) //32 is the default buffer size
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(subscriber());

        sleepSeconds(60);
    }
}
