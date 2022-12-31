package com.rp.sec03;

import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec08FluxPush {
    public static void main(String[] args) {
        //this is not thread safe
        NameProducer nameProducer = new NameProducer();
        Flux.push(nameProducer).subscribe(subscriber());
        //nameProducer.produce();
        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();

        }

       // sleepSeconds(10);
    }
}
