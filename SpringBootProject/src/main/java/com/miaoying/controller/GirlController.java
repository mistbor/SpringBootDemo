package com.miaoying.controller;

import com.miaoying.entity.Girl;
import com.miaoying.entity.Result;
import com.miaoying.repository.GirlRepository;
import com.miaoying.service.GirlService;
import com.miaoying.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ${MiaoYing} on 2017/7/8.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 根据名称查询girl
     * @param name
     * @return
     */
    @GetMapping(value = "/girlByName")
    public List<Girl> findByName(@RequestParam("name")String name){
       return girlRepository.findByName(name);
    }

    /**
     * 查询girl列表数据
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
                return  girlRepository.findAll();
            }

    /**
     * 新增一条girl数据
     * @param name
     * @param sex
     * @return
     */
    @PostMapping(value = "/add")
    public Girl girlAdd(@RequestParam("name") String name,
                          @RequestParam("sex") String sex){
        Girl girl=new Girl();
        girl.setName(name);
        girl.setSex(sex);
        return girlRepository.save(girl);
    }

    @PostMapping(value = "/addGirl")
    public Result<Girl> girlAdd2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
          return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setName(girl.getName());
        girl.setSex(girl.getSex());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 根据id查询一条girl数据
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 修改girl数据
     * @param id
     * @param name
     * @param sex
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("sex")String sex){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setSex(sex);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/getAge/{id}")
    public void getName(@PathVariable("id") Integer id) throws Exception {
        girlService.getName(id);
    }























}
