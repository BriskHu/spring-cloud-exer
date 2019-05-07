package com.briskhu.order.service1.controller;

import com.briskhu.order.service1.dto.debugplatform.ManufacturerKeyInfo;
import com.briskhu.order.service1.dto.debugplatform.ReqManufacturerKeyDto;
import com.briskhu.order.service1.dto.debugplatform.ResManufacturerKeyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-05-07
 **/
@RestController
@RequestMapping("/localMock")
public class LocalMockController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalMockController.class);

    /* ---------------------------------------- fileds ---------------------------------------- */


    /* ---------------------------------------- methods ---------------------------------------- */
    @PostMapping("/debug-platform/manufacturer/secret/key")
    public ResManufacturerKeyInfo getManufactureKey(ReqManufacturerKeyDto reqManufacturerKeyDto){
        LOGGER.info("[getManufactureKey] 入参：reqManufacturerKeyDto = {}", reqManufacturerKeyDto);
        ResManufacturerKeyInfo respDto = new ResManufacturerKeyInfo();
        respDto.setCode(0);
        ManufacturerKeyInfo manufacturerKeyInfo = new ManufacturerKeyInfo();
        manufacturerKeyInfo.setVersion("1.0");
        manufacturerKeyInfo.setEncryptKey("testManuEncryKey");
        respDto.setData(manufacturerKeyInfo);
        LOGGER.info("[getManufactureKey] end：respDto = {}", respDto);
        return respDto;
    }

}


