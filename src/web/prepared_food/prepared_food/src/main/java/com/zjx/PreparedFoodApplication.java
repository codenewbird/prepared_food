package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class PreparedFoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(PreparedFoodApplication.class,args);
    }
}
