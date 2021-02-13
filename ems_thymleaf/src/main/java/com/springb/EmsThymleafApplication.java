package com.springb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.springb.dao")

public class EmsThymleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsThymleafApplication.class, args);
    }

}
