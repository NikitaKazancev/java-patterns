package com.example.tests;

import com.example.tests.db.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.concurrent.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TestsApplication {
    public static void main(String[] args)  {
        SpringApplication.run(TestsApplication.class);
    }
}
