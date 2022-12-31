package com.rp.sec02.helper;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.sleepSeconds;

public class NameGenerator {
    public static List<String> getNames(Integer count) {
        List<String> names = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            names.add(getName());
        }
        return names;
    }
    public static Flux<String> getFluxNames(Integer count) {
        return Flux.range(1, count).map(i -> getName());
    }
    private static String getName() {
        sleepSeconds(1);
        return faker().name().fullName();
    }
}
