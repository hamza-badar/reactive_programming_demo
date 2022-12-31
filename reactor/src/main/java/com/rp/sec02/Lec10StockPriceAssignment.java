package com.rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import static com.rp.sec02.assignment.StockPricePublisher.getPrice;

public class Lec10StockPriceAssignment {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        Subscriber<Integer> subscriber = getPrice().log().subscribeWith(new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(LocalDateTime.now() + " : Price : " + integer);
                if (integer > 110 || integer < 90) {
                    subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
                latch.countDown();
            }

            @Override
            public void onComplete() {
                latch.countDown();
            }
        });

        //subscriber.onError(new Throwable("Test failure"));

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
