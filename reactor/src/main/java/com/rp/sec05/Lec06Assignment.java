package com.rp.sec05;

import com.rp.sec05.assignment.InventoryService;
import com.rp.sec05.assignment.OrderService;
import com.rp.sec05.assignment.RevenueService;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.getPurchaseOrderFlux().subscribe(inventoryService.subscribeOrderStream());
        orderService.getPurchaseOrderFlux().subscribe(revenueService.subscribeOrderStream());

        inventoryService.inventoryStream().subscribe(subscriber("inventory"));
        revenueService.revenueStream().subscribe(subscriber("revenue"));

        sleepSeconds(10);
    }
}
