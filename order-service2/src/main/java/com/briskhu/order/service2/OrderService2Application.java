package com.briskhu.order.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderService2Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderService2Application.class, args);
    }

}
