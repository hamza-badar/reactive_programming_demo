package com.rp.sec01;

import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.*;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(1).subscribe(
                onNext(),
                onError(),
                onComplete()
        );

        userRepository(2).subscribe(
                onNext(),
                onError(),
                onComplete()
        );

        userRepository(3).subscribe(
                onNext(),
                onError(),
                onComplete()
        );
    }

    private static Mono<String> userRepository(int userId) {
        if(userId == 1) {
            return Mono.just(faker().name().firstName());
        } else if(userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new Throwable("user not present"));
        }
    }
}
