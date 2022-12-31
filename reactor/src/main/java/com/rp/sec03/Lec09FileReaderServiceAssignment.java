package com.rp.sec03;

import com.rp.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.rp.courseutil.Util.faker;
import static com.rp.courseutil.Util.subscriber;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        fileReaderService.read(path).map(
                line -> {
                    Integer integer = faker().random().nextInt(0, 10);
                    if(integer > 8) {
                        //throw new RuntimeException("force exception");
                    }
                    return line;
                }
        ).take(5).subscribeWith(subscriber());  //subscribe(subscriber());
    }
}
