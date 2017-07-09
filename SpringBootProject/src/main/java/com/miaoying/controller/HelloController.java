package com.miaoying.controller;

import com.miaoying.entity.Miaoying;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ${MiaoYing} on 2017/7/8.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${age}")
    private String age;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello miaoying~"+content;
    }

    @Autowired
    private Miaoying miaoying;

    @RequestMapping(value = "/miaoying/{id}",method = RequestMethod.GET)
    public String miaoying(@PathVariable("id") Integer id){
        return "id:"+id;
/*
        return miaoying.getHouse()+miaoying.getCar();
*/
    }

@GetMapping(value = "/miaoying2/{id}")
    public String miaoying2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id:"+id;
/*
        return miaoying.getHouse()+miaoying.getCar();
*/
    }


    @RequestMapping(value = "/miao",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

}

