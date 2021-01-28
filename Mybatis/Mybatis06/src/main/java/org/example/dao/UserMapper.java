package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User queryUser(@Param("id") int id);
}
