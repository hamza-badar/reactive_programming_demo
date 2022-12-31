package com.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

public class OrderService {
    private Flux<PurchaseOrder> purchaseOrderFlux;
    public Flux<PurchaseOrder> getPurchaseOrderFlux() {
        if(Objects.isNull(purchaseOrderFlux)) {
            purchaseOrderFlux = getOrderStream();
        }
        return purchaseOrderFlux;
    }
    private Flux<PurchaseOrder> getOrderStream() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new PurchaseOrder())
                .doOnNext(System.out::println)
                .publish()
                .refCount(2);
    }
}
