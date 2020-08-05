package com.zz.one;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.zz.zzclientone.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class ZzClientOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzClientOneApplication.class, args);
    }

}
