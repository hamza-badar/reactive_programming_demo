package com.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {
    private Map<String, Double> db;

    public RevenueService() {
        db = new HashMap<>();
    }

    public Consumer<PurchaseOrder> subscribeOrderStream() {
        return purchaseOrder -> {
            db.computeIfPresent(purchaseOrder.getCategory(), (category, revenue) -> revenue + purchaseOrder.getPrice());
            db.computeIfAbsent(purchaseOrder.getCategory(), (category) -> 0.0 + purchaseOrder.getPrice());
        };
    }

    public Flux<String> revenueStream() {
        return Flux.interval(Duration.ofSeconds(1)).map(i -> db.toString());
    }
}
