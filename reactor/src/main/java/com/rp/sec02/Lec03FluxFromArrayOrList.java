package com.rp.sec02;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static com.rp.courseutil.Util.onNext;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> strArr = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strArr).subscribe(onNext());

        Integer [] arr = {1,2,3};
        Flux.fromArray(arr).subscribe(onNext());

    }
}
