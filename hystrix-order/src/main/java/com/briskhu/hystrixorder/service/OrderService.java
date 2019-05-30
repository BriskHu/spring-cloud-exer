package com.briskhu.hystrixorder.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-05-30
 **/
@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    /* ---------------------------------------- fileds ---------------------------------------- */
    @Autowired
    RestTemplate restTemplate;

    /* ---------------------------------------- methods ---------------------------------------- */
    @HystrixCommand(fallbackMethod = "whenProductServiceFailed")
    public String getProduct(){
        LOGGER.info("[getProduct] start ...");
        String productResut = restTemplate.getForEntity("http://HYSTRIX-PRODUCT/getProduct", String.class).getBody();

        return productResut;

    }

    public String whenProductServiceFailed(){
        return "The hystrix-product service crashed.";
    }
}


