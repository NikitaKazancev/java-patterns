package com.example.pw18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
	exclude = { DataSourceAutoConfiguration.class }
)
public class Pw18Application {

	public static void main(String[] args) {
		SpringApplication.run(com.example.pw18.Pw18Application.class, args);
	}
}
