package com.seed.winter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.seed.winter.dao")
@SpringBootApplication
public class WinterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterApplication.class, args);
    }

}
