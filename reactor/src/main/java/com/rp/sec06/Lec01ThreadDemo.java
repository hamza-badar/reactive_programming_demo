package com.rp.sec06;

import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThread("create");
            fluxSink.next(1);
        }).doOnNext(o -> printThread("next " + o));
        flux.subscribe(o -> printThread("sub " + o));

        Runnable runnable = () -> flux.subscribe(o -> printThread("sub " + o));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
    }

    private static void printThread(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
