package com.miaoying.handle;

import com.miaoying.entity.Result;
import com.miaoying.exception.GirlException;
import com.miaoying.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ${MiaoYing} on 2017/7/9.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            return ResultUtil.error(102,"未知错误");
        }
    }
}
