package com.capgemini.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by gerard on 8-5-17.
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
        String database = "hotel2";
        String url = "jdbc:mysql://capgemini-academy.ck17qz3qdemp.eu-west-1.rds.amazonaws.com:8080/" + database;
        String username = database;
        String password = "capgemini";
        return new DriverManagerDataSource(url, username, password);
    }

}
