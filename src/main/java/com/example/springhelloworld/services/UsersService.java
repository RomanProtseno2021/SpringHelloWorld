package com.example.springhelloworld.services;

import com.example.springhelloworld.mappers.UsersMapper;
import com.example.springhelloworld.stucts.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsersService {

    @Setter
    @Autowired
    private UsersMapper usersMapper;

    public List<User> getAllUsers(){
        User user0 = new User(1L, "fdhgfj", "Bob", 45);
        User user1 = new User(2L, "Rat", "Bob", 45);
        User user2 = new User(3L, "Sen", "Bob", 45);
        List<User> users = Arrays.asList(user0, user1, user2);
        return usersMapper.getAllUsers();
    }
}
