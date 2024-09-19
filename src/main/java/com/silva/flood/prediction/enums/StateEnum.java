package com.silva.flood.prediction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangsiqi
 */

@Getter
@AllArgsConstructor
public enum StateEnum {
    /**
     * 状态枚举
     */
    STATE_DELETE(0, "delete"),
    STATE_NORMAL(1, "normal");

    final Integer code;
    final String desc;
}
