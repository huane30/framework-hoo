package com.hoo.framework.swagger.controller;

import com.hoo.framework.swagger.dto.UserInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ravihoo on 04/03/2018.
 */
@RestController
@Api(value= "UserInfo",description = "人员基本信息")
public class UserInfoController {

    @RequestMapping(value = "/selectAllUsers", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有的人员信息", notes = "查询所有的人员信息")
    public String selectAllUsers(@RequestBody UserInfoDto dto) {

        return "success";

    }

    @RequestMapping(value= "/show",method = RequestMethod.POST)
    @ApiOperation(value = "测试信息", notes = "测试信息")
    public String show(){
        return "Hello World";
    }
}
