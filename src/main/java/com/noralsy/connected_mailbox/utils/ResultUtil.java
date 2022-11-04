package com.noralsy.connected_mailbox.utils;

public class ResultUtil {
    public static <T> BaseResult<T> success(T data){
        return new BaseResult<>("success", data);
    }

    public static <T> BaseResult<T> error(String errorMsg){
        return new BaseResult<>(errorMsg, null);
    }

    public static <T> BaseResult<T> error(){
        return new BaseResult<>("failed", null);
    }
}
