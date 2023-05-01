package com.misikovich.javaprodz14glovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    private final static String IP = "5.45.157.89";
    private final static Integer PORT = 5432;
    private final static String DATABASE = "postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "postgrespw";
    @Bean
    public DataSource create() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(String.format("jdbc:postgresql://%s:%s/%s", IP, PORT, DATABASE));
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
