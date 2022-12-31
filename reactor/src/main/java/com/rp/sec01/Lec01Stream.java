package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i *2;}
                );
        //streams are lazy hence when we'll just use its object we see no delay of 10 sec
        System.out.println(stream);
        //now once we invoked the stream we'll see the delay
        stream.forEach(System.out::println);
    }
}
