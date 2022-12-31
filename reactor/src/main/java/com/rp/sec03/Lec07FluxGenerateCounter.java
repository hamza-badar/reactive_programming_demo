package com.rp.sec03;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(() -> 1,
                (counter, sink) -> {
                    String country = faker().country().name();
                    sink.next(country);
                    if(counter > 10 || country.equalsIgnoreCase("canada")) {
                        sink.complete();
                    }
                    return counter +1;
                })
                .subscribe(subscriber());
    }
}
