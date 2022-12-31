package com.rp.sec05.assignment;

import lombok.Data;
import lombok.ToString;

import static com.rp.courseutil.Util.faker;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;

    private int quantity;

    public PurchaseOrder() {
        this.item = faker().commerce().productName();
        this.price = Double.parseDouble(faker().commerce().price());
        this.category = faker().commerce().department();
        this.quantity = faker().random().nextInt(1,3);
    }
}
