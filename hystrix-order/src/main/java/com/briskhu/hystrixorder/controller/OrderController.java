package com.briskhu.hystrixorder.controller;

import com.briskhu.hystrixorder.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-05-30
 **/
@RestController
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /* ---------------------------------------- fileds ---------------------------------------- */
    @Autowired
    OrderService orderService;

    /* ---------------------------------------- methods ---------------------------------------- */
    /**
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello(){
        LOGGER.info("[hello] start ...");
        return new ResponseEntity<String>("Hell order service", HttpStatus.OK);
    }

    @GetMapping("/product/info")
    public String getProductService(){
        return orderService.getProduct();
    }
}


