package com.example.schoolproject.mapper;

import com.example.schoolproject.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    List<User> getAll();

    @Select("select * from users where id = #{id}")
    User getUserById(Long id);

    @Select("select * from users where userName = #{userName} and password = #{password}")
    User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    @Insert("insert into users (userName, firstName, lastName, dateOfBirth, password)\n" +
            "values (#{userName}, #{firstName}, #{lastName}, #{dateOfBirth}, #{password});")
    void addUser(User user);

    @Delete("delete from users where id = #{id}")
    void deleteUserById(Long id);
}
