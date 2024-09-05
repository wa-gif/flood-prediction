package com.silva.flood.prediction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnums {
    /**
     * 响应状态枚举
     */
    BIZ_SUCCESS("000000", "success"),
    BIZ_ERROR("999999", "request fail"),
    ;

    final String code;
    final String message;
}