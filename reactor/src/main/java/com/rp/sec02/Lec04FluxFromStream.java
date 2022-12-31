package com.rp.sec02;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

import static com.rp.courseutil.Util.*;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        // stream.forEach(System.out::println);
        Flux<Integer> flux = Flux.fromStream(stream);

        flux.subscribe(onNext(),
                onError(),
                onComplete());

        flux.subscribe(onNext(),
                onError(),
                onComplete());

        //so what is happened here is that the first subscriber consumed the stream pipeline and the stream is flushed
        //inorder to fix this we should return new stream every time

        Flux<Integer> fluxWithStream = Flux.fromStream(list::stream);

        fluxWithStream.subscribe(onNext(),
                onError(),
                onComplete());

        fluxWithStream.subscribe(onNext(),
                onError(),
                onComplete());


    }
}
