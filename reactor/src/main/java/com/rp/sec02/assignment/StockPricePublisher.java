package com.rp.sec02.assignment;

import com.sun.jdi.IntegerValue;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static com.rp.courseutil.Util.faker;

public class StockPricePublisher {
    public static Flux<Integer> getPrice() {
        AtomicInteger basePrice = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> basePrice.getAndAccumulate(faker().random().nextInt(-5,5),Integer::sum));
    }
}
