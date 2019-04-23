package com.briskhu.eureka.client01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/provider")
public class ProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

    /* ---------------------------------------- fileds ---------------------------------------- */


    /* ---------------------------------------- methods ---------------------------------------- */
    /**
     * 验证项目已经在运行中
     * @return
     */
    @GetMapping("/isWorking")
    public ResponseEntity<String> isWorking(){
        return new ResponseEntity<>("The eureka-client01 service is performing now.", HttpStatus.OK);
    }

}


