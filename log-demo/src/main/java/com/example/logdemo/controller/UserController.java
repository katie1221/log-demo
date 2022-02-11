package com.example.logdemo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.logdemo.dao.UserMapper;
import com.example.logdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qzz
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 通过Class的方式初始化日志对象
     */
//    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 查看用户列表
     */
    @GetMapping ("/listAll")
    public Map<String,Object> listAll(){
        log.info("查看用户列表");
        Map<String,Object> result = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> list= userMapper.selectList(queryWrapper);
        result.put("code","200");
        result.put("data",list);
        log.debug("返回结果集个数："+list.size());
        return result;
    }

    /**
     * 添加用户信息
     */
    @PostMapping("add")
    public Map<String,Object> addProduct(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        int n = userMapper.insert(user);
        if(n>0){
            result.put("code","200");
            result.put("id",user.getId());
        }else{
            result.put("code","400");
            result.put("msg","添加用户失败");
        }
        return result;
    }

    /**
     * 编辑商品信息
     */
    @PostMapping("update")
    public Map<String,Object> updateProduct(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        int n = userMapper.updateById(user);
        if(n>0){
            result.put("code","200");
        }else{
            result.put("code","400");
            result.put("msg","编辑用户失败");
        }
        return result;
    }
}
