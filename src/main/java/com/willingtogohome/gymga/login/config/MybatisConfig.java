package com.willingtogohome.gymga.login.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.willingtogohome.gymga", annotationClass = Mapper.class)
public class MybatisConfig {
}
