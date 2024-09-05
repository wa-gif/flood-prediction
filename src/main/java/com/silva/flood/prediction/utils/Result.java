package com.silva.flood.prediction.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private String status;
    private String message;
    private T data;

    public static <T> Result<T> ok() {
        return new Result<>(ResultEnums.BIZ_SUCCESS.getCode(), ResultEnums.BIZ_SUCCESS.getMessage(), null);
    }
    public static <T> Result<T> okSetMessage(String message) {
        return new Result<>(ResultEnums.BIZ_SUCCESS.getCode(), message, null);
    }
    public static <T> Result<T> ok(T data) {
        return new Result<>(ResultEnums.BIZ_SUCCESS.getCode(), ResultEnums.BIZ_SUCCESS.getMessage(), data);
    }
    public static <T> Result<T> failed() {
        return new Result<>(ResultEnums.BIZ_ERROR.getCode(), ResultEnums.BIZ_ERROR.getMessage(), null);
    }
    public static <T> Result<T> failedSetMessage(String message) {
        return new Result<>(ResultEnums.BIZ_ERROR.getCode(), message, null);
    }
}
