package com.rp.sec03;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        //try the same code after removing fluxSink.isCancelled()
        //only one instance of fluxSink
        Flux.create(fluxSink ->{
            String country;
            do{
                country = faker().country().name();
                System.out.println("emitting : " + country);
                fluxSink.next(country);
            }while(!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        }).take(3)
                .subscribe(subscriber());
    }
}
