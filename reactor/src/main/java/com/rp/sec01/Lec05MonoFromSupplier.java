package com.rp.sec01;

import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import static com.rp.courseutil.Util.*;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        //we should only use Mono.just when we have data present already because it instantly start processing
        Mono<String> monoJust = Mono.just(getName());

        Supplier<String> supplier = Lec05MonoFromSupplier::getName;
        Mono<String> monoSupplier = Mono.fromSupplier(supplier);

        monoSupplier.subscribe(onNext(),
                onError(),
                onComplete());


        Callable<String> callable = Lec05MonoFromSupplier::getName;
        Mono<String> monoCallable = Mono.fromCallable(callable);

        monoCallable.subscribe(onNext(),
                onError(),
                onComplete());
    }

    private static String getName() {
        System.out.println("Generating name : ");
        return faker().name().fullName();
    }
}
