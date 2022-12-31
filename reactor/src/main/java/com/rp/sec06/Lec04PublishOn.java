package com.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static com.rp.courseutil.Util.sleepSeconds;

public class Lec04PublishOn {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThread("create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
                sleepSeconds(1);
            }
            fluxSink.complete();
        }).doOnNext(o -> printThread("next " + o));

        Runnable runnable = () -> flux
                .doOnNext((o1) -> printThread("onNext1" +o1))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext((o) -> printThread("onNext1" +o))
                .publishOn(Schedulers.parallel())
                .subscribe(o -> printThread("sub " + o));

        for (int i = 0; i < 1; i++) {
            new Thread(runnable).start();
        }

        sleepSeconds(6);
    }

    private static void printThread(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
