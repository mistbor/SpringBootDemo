package com.miaoying.exception;

import com.miaoying.enums.ResultEnum;

/**
 * Created by ${MiaoYing} on 2017/7/9.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code=code;
    }

}
