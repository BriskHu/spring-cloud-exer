package com.briskhu.order.service1.dto.debugplatform;

import lombok.Data;

/**
 * 获取直连平台厂商秘钥请求体
 * @date 2019/3/31
 * @modify
 */
@Data
public class ReqManufacturerKeyDto {

    /**
     * 厂商id
     */
    private long manufacturerId;
    /**
     * 厂商编码
     */
    private String manufacturer;

    @Override
    public String toString() {
        return "ReqManufacturerKeyDto{" +
                "manufacturerId=" + manufacturerId +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
