package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.*;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<String> mono1 = Mono.just("ball");

        Mono<Integer> mono2 = Mono.just("ball")
                .map(String::length)
                .map(ele -> ele / 0);

        //just subscribe will do nothing
        mono1.subscribe();

        //
        mono1.subscribe(onNext(),
                onError(),
                onComplete());

        mono2.subscribe(onNext(),
                onError(),
                onComplete());
    }
}
