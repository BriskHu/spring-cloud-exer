package com.briskhu.loadbalance.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-04-24
 **/
@RestController
public class LoadbalanceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadbalanceController.class);

    /* ---------------------------------------- fileds ---------------------------------------- */
    @Autowired
    RestTemplate restTemplate;

    /* ---------------------------------------- methods ---------------------------------------- */
    @GetMapping("/product/hello")
    public String productHello(){
        LOGGER.info("[productHello] 入参：无入参。");
        return restTemplate.getForEntity("http://PRODUCT-SERVICE/hello", String.class).getBody();
    }

    @GetMapping("/order/hello")
    public String orderHello(){
        LOGGER.info("[orderHello] 入参：无入参。");
        return restTemplate.getForEntity("http://ORDER-SERVICE/hello", String.class).getBody();
    }
}


