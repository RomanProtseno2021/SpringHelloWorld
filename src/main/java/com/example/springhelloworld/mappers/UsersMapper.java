package com.example.springhelloworld.mappers;

import com.example.springhelloworld.stucts.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface UsersMapper {

    List<User> getAllUsers();

    User getUserById(@Param("id") Integer id);

    User addUser(@Param("user") User user);

    boolean ifUserExists(@Param("idUser") Integer id);

    User updateUser(@Param("idUser") Integer id, @Param("user") User user);

    Boolean deleteUserById(@Param("id") Integer id);
}
