package com.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import static com.rp.courseutil.Util.sleepSeconds;

public class Lec06Parallel {
    public static void main(String[] args) {
        Flux.range(1,100)
                .parallel(10)
                .runOn(Schedulers.boundedElastic())
                .subscribe(o -> printThread("sub " + o));

        sleepSeconds(6);
    }

    private static void printThread(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
