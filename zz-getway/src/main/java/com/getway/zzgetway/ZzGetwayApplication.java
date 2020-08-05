package com.getway.zzgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZzGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzGetwayApplication.class, args);
    }

}
