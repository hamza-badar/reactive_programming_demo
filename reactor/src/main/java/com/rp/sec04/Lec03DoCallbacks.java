package com.rp.sec04;

import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            //fluxSink.complete();
            fluxSink.error(new RuntimeException("force error"));
            System.out.println("sink completed");
        }).doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : "+o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe 1 : " + subscription))
                .doOnRequest(value -> System.out.println("doOnRequest : " + value))
                .doOnError(throwable -> System.out.println("doOnError : "+throwable))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe 2 : " + subscription))
                .doFinally(signalType -> System.out.println("doFinally 1 : " + signalType))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : "+o))
                .doFirst(() -> System.out.println("doFirst 3"))
                .take(2)
                .doFinally(signalType -> System.out.println("doFinally 2 : " + signalType))
                .subscribe(subscriber());

        //sleepSeconds(10);
    }
}
