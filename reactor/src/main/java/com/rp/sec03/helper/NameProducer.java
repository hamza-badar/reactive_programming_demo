package com.rp.sec03.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

import static com.rp.courseutil.Util.faker;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
            fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = faker().name().fullName();
        String thread = Thread.currentThread().getName();
        fluxSink.next(thread + " : " + name);
    }
}
