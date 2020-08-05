package com.client.two.comclienttwo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.client.two.comclienttwo.dao")
public class ComClientTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComClientTwoApplication.class, args);
    }

}
