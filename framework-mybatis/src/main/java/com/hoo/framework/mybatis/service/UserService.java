package com.hoo.framework.mybatis.service;

import com.hoo.framework.mybatis.entity.User;
import com.hoo.framework.mybatis.mapper.UserMapper;
import com.hoo.framework.mybatis.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ravihoo on 08/03/2018.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
