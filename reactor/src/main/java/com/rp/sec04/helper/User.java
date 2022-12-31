package com.rp.sec04.helper;

import lombok.Data;
import lombok.ToString;

import static com.rp.courseutil.Util.faker;

@Data
@ToString
public class User {
    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = faker().name().fullName();
    }
}
