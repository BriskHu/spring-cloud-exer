package com.briskhu.order.service1.dto.debugplatform;

import lombok.Data;

/**
 * 厂商秘钥信息返回体
 * @date 2019/3/31
 * @modify
 */
@Data
public class ResManufacturerKeyInfo {

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误描述信息
     */
    private String message;
    /**
     * 错误描述信息
     */
    private ManufacturerKeyInfo data;

    @Override
    public String toString() {
        return "ResManufacturerKeyInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
