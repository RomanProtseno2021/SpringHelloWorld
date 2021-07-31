package com.example.springhelloworld.mappers;

import com.example.springhelloworld.stucts.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {

    List<User> getAllUsers();

    User getUserById(@Param("id") Integer id);
}
