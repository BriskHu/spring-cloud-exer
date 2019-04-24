package com.briskhu.loadbalance.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class LoadbalanceServiceApplication {

    /**
     * 使用负载均衡的 RestTemplate。
     * 加了注解@LoadBalance之后，这个restTemplate实例就具有负载均衡的能力。
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(LoadbalanceServiceApplication.class, args);
    }

}
