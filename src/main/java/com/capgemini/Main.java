package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);
        Properties properties = new Properties();
        properties.setProperty("spring.jpa.generate-ddl","true");
        properties.setProperty("spring.data.rest.base-path","api");
        SpringApplication springApplication = new SpringApplication(Main.class);
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }
}
