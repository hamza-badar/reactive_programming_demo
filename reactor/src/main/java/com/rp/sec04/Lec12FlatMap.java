package com.rp.sec04;

import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

import static com.rp.courseutil.Util.sleepSeconds;
import static com.rp.courseutil.Util.subscriber;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // whenever return type is Mono or FLux
                .filter(purchaseOrder -> purchaseOrder.getPrice() > 10)
                .subscribe(subscriber());

        sleepSeconds(10);
    }
}
