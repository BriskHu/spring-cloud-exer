package com.briskhu.cloudconfiglocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class CloudConfigLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigLocalApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

