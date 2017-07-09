package com.miaoying.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by ${MiaoYing} on 2017/7/8.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Girl() {
    }

    public Girl(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
