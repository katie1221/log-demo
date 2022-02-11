package com.example.logdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.logdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author qzz
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
