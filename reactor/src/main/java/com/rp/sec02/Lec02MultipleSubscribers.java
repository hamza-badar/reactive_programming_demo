package com.rp.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
        flux.subscribe(ele -> System.out.println("Sub 1 : " + ele));
        flux.filter(ele -> ele % 2 == 0).
                subscribe(ele -> System.out.println("Sub 2 : " + ele));
    }
}
