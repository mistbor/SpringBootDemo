package com.miaoying.repository;

import com.miaoying.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ${MiaoYing} on 2017/7/8.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByName(String name);
}
