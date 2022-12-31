package com.rp.sec01;

import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.*;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(getRunnable())
                .subscribe(onNext(),
                        onError(),
                        () -> System.out.println("process is done sending emails now ...."));
    }

    private static Runnable getRunnable() {
        return () -> {
            System.out.println("Inside Runnable executing some sort of task which consume time and you want notification once finished");
            sleepSeconds(4);
        };
    }
}
