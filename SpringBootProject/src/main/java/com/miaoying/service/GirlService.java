package com.miaoying.service;

import com.miaoying.entity.Girl;
import com.miaoying.enums.ResultEnum;
import com.miaoying.exception.GirlException;
import com.miaoying.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ${MiaoYing} on 2017/7/9.
 */
@Component
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getName(Integer id)throws Exception{
        Girl girl=girlRepository.getOne(id);
         String name=girl.getName();
        if(name.length()<3){
            throw new GirlException(ResultEnum.TOO_SHORT);
        }else if(name.length()>4){
            throw new GirlException(ResultEnum.TOO_LONG);
        }
    }

}

