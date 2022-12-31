package com.rp.sec01;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static com.rp.courseutil.Util.*;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(onNext());

        sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> faker().name().fullName());
    }
}
