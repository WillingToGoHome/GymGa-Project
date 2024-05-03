package com.willingtogohome.gymga.login.config.handler;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.willingtogohome", annotationClass = Mapper.class)
public class MybatisConfig {
}
