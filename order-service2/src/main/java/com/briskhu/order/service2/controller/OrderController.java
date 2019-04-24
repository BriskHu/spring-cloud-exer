package com.briskhu.order.service2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-04-24
 **/
@RestController
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /* ---------------------------------------- fileds ---------------------------------------- */


    /* ---------------------------------------- methods ---------------------------------------- */
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        LOGGER.info("[hello] 入参：无入参。");
        return new ResponseEntity<>("Hello from order-sevice 1", HttpStatus.OK);
    }

}


