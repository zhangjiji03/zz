package com.zz.two;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.zz.two.dao")
public class ZzClientTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzClientTwoApplication.class, args);
    }

}
