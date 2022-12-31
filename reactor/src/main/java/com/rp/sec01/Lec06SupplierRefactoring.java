package com.rp.sec01;

import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.*;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        getName();
        getName();
        getName().subscribe(onNext());
        getName();
    }
    private static Mono<String> getName() {
        System.out.println("Entered getName() method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name : ");
            sleepSeconds(5);
            return faker().name().firstName();
        }).map(String::toUpperCase);
    }
}
