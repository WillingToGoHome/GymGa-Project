package com.willingtogohome.gymga;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.willingtogohome.gymga")
@MapperScan(basePackages = "com.willingtogohome.gymga", annotationClass = Mapper.class)
public class GymGaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymGaProjectApplication.class, args);
    }

}
