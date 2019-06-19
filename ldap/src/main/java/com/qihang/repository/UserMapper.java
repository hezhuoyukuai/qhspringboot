package com.qihang.repository;

import com.qihang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface  UserMapper {
    @Select("select * from qh_user")
    List<User> getUserList();

    @SelectKey(keyProperty = "qh_user.id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "qh_user.id", useGeneratedKeys = true)
    @Insert("insert into qh_user(name,age) values(#{name},#{age})")
    void addUser(User user);

    @Delete("delete from qh_user where name = #{name}")
    void deleteUsers(String name);

    @Update("update qh_user set name=#{name},age=#{age} where id=#{id}")
    void updateUserName(User user);

}
