package com.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static com.rp.courseutil.Util.sleepSeconds;

public class Lec02SubscribOnDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThread("create");
            fluxSink.next(1);
        }).doOnNext(o -> printThread("next " + o));

        Runnable runnable = () -> flux
                .doFirst(() -> printThread("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThread("first1"))
                .subscribe(o -> printThread("sub " + o));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        sleepSeconds(3);
    }

    private static void printThread(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
