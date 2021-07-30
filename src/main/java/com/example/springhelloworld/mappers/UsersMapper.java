package com.example.springhelloworld.mappers;

import com.example.springhelloworld.stucts.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    Integer getAllUsers();
}
