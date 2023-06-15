package com.example.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Function;

@SpringBootApplication
public class TestsApplication {
    public static void test(Function<Integer, String> f) {

    }

    public static void main(String[] args) {
        test((a) -> a.toString() + "12");
        SpringApplication.run(TestsApplication.class, args);
    }

}
