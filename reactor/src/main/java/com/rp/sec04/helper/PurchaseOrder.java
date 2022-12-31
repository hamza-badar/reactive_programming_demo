package com.rp.sec04.helper;

import lombok.Data;
import lombok.ToString;

import static com.rp.courseutil.Util.faker;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private double price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.item = faker().commerce().productName();
        this.price = Double.parseDouble(faker().commerce().price());
        this.userId = userId;
    }
}
