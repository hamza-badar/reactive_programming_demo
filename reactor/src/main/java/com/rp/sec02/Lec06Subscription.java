package com.rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

import static com.rp.courseutil.Util.sleepSeconds;

public class Lec06Subscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> subscriptionObject = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Successfully subscribed");
                        subscriptionObject.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
        sleepSeconds(3);
        subscriptionObject.get().request(3);
        sleepSeconds(5);
        subscriptionObject.get().request(3);
        sleepSeconds(5);
        System.out.println("going to cancel the subscription");
        subscriptionObject.get().cancel();
        sleepSeconds(3);
        subscriptionObject.get().request(4);
    }
}
