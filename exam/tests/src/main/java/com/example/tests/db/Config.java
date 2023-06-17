package com.example.tests.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class Config {
    @Bean
    public Connection connection() throws SQLException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "pass");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }
}
