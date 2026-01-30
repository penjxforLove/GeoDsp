package com.geo.dsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
@MapperScan("com.geo.dsp.module.**.mapper") // 扫描所有模块下的mapper接口
public class GeoDspApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoDspApplication.class, args);
    }

}