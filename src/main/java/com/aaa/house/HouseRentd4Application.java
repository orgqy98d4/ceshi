package com.aaa.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aaa.house.dao")
public class HouseRentd4Application {

    public static void main(String[] args) {
        SpringApplication.run(HouseRentd4Application.class, args);
    }

}
