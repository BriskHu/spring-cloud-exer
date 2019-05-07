package com.briskhu.order.service1.dto.debugplatform;

import lombok.Data;

/**
 * 秘钥信息
 * @date 2019/4/6
 * @modify
 */
@Data
public class ManufacturerKeyInfo {

    /**
     * 厂商id
     */
    private long  manufacturerId;
    /**
     * 厂商编码
     */
    private String  manufacturer;
    /**
     * 秘钥版本
     */
    private String version;
    /**
     * 秘钥
     */
    private String encryptKey;

    private String createTime;

    private String updateTime;

    @Override
    public String toString() {
        return "ManufacturerKeyInfo{" +
                "manufacturerId=" + manufacturerId +
                ", manufacturer='" + manufacturer + '\'' +
                ", version='" + version + '\'' +
                ", encryptKey='" + encryptKey + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

}
