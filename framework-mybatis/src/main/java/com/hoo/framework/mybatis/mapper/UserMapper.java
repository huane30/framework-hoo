package com.hoo.framework.mybatis.mapper;

import com.hoo.framework.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ravihoo on 08/03/2018.
 */
@Mapper
public interface UserMapper {

    User getUserById(@Param("id")String id);

}
