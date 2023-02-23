package com.example.pw18.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAspectJAutoProxy
@EnableAsync
@Import({DatabaseConfig.class, EmailConfig.class})
public class AppConfig {
}
