package com.example.springhelloworld.services;

import com.example.springhelloworld.mappers.UsersMapper;
import com.example.springhelloworld.stucts.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UsersService {

    @Setter
    @Autowired
    private UsersMapper usersMapper;

    public List<User> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    public User getUserById(Integer id) {
        User user = usersMapper.getUserById(Objects.requireNonNull(id, "id must be not null"));
        if (user != null) {
            return user;
        }
        throw new IllegalArgumentException("Користувача з id - " + id + " в базі даних не знайдено!");
    }
}
