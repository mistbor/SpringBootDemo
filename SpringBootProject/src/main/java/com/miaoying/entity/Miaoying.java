package com.miaoying.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by ${MiaoYing} on 2017/7/8.
 */
@ConfigurationProperties(prefix = "miaoying")
@Component
public class Miaoying {
    private String house;
    private String car;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
