package com.rp.sec01;

import com.rp.sec01.assignment.FileService;
import reactor.core.publisher.Mono;

import static com.rp.courseutil.Util.*;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        Mono<Void> monoWriter = FileService.write("file01.txt", faker().country().name());
        Mono<String> monoReader = FileService.read("file02.txt");
        Mono<Void> monoWriter1 = FileService.write("file03.txt", faker().country().name());


        monoWriter.subscribe(onNext(),
                onError(),
                onComplete());

        monoReader.subscribe(onNext(),
                onError(),
                onComplete());

        monoWriter1.subscribe(onNext(),
                onError(),
                onComplete());
    }
}
