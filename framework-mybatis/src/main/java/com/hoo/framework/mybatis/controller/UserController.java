package com.hoo.framework.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.hoo.framework.mybatis.entity.User;
import com.hoo.framework.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ravihoo on 08/03/2018.
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserById",method = RequestMethod.GET)
    @ResponseBody
    public String getUserById( @RequestParam(value ="id",required = true) String id){
        User result = userService.getUserById(id+"");

        return JSONObject.toJSONString(result);
    }
}
