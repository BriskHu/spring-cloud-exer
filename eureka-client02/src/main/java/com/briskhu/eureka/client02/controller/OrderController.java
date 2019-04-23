package com.briskhu.eureka.client02.controller;

import com.briskhu.eureka.client02.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-04-23
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /* ---------------------------------------- fileds ---------------------------------------- */
    @Autowired
    private OrderService orderService;

    /* ---------------------------------------- methods ---------------------------------------- */
    /**
     * 验证项目已经在运行中
     * @return
     */
    @GetMapping("/isWorking")
    public ResponseEntity<String> isWorking(){
        return new ResponseEntity<>("The eureka-client02 service is performing now.", HttpStatus.OK);
    }

}


