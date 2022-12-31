package com.rp.sec04.helper;

import lombok.Data;
import lombok.ToString;

import static com.rp.courseutil.Util.faker;

@Data
@ToString
public class Person {
    private String name;
    private int age;
    public Person() {
        this.name = faker().name().firstName();
        this.age = faker().random().nextInt(1,30);
    }
}
