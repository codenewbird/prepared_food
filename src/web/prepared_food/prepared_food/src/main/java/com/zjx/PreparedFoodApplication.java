package com.zjx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.zjx.dao")
@MapperScan("com.zjx.rbacredis.mapper")
public class PreparedFoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(PreparedFoodApplication.class,args);
    }
}
