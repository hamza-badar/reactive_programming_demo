package com.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryService {
    private Map<String, Integer> db;

    public InventoryService() {
        db = new HashMap<>();
    }

    public Consumer<PurchaseOrder> subscribeOrderStream() {
        return purchaseOrder -> {
            db.computeIfPresent(purchaseOrder.getCategory(), (category, quantity) -> quantity - purchaseOrder.getQuantity());
            db.computeIfAbsent(purchaseOrder.getCategory(), (category) -> 100 - purchaseOrder.getQuantity());
        };
    }

    public Flux<String> inventoryStream() {
        return Flux.interval(Duration.ofSeconds(1)).map(i -> db.toString());
    }
}
