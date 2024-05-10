package com.willingtogohome.gymga;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@MapperScan(basePackages = "com.willingtogohome.gymga")
public class GymGaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymGaProjectApplication.class, args);
    }

}
