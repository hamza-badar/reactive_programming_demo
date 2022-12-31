package com.rp.sec02;

import reactor.core.publisher.Flux;

import java.util.List;

import static com.rp.courseutil.Util.onNext;
import static com.rp.sec02.helper.NameGenerator.getFluxNames;
import static com.rp.sec02.helper.NameGenerator.getNames;
public class Lec07FluxVsList {
    public static void main(String[] args) {
        List<String> namesList = getNames(5);
        System.out.println(namesList);

        Flux<String> fluxNames = getFluxNames(5);
        fluxNames.subscribe(onNext());
    }
}
