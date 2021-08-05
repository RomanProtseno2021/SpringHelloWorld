package com.example.springhelloworld.services;

import com.example.springhelloworld.mappers.UsersMapper;
import com.example.springhelloworld.stucts.User;
import io.swagger.annotations.ApiParam;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
        Objects.requireNonNull(id, "Id користувача не задано!");
        User user = usersMapper.getUserById(id);
        return Objects.requireNonNull(user, "Користувача з id - " + id + " в базі даних не знайдено!");
    }

    public User addUser(User user) {
        checkUser(user);
        return usersMapper.addUser(user);
    }

    private void checkUser(User user) {
        Objects.requireNonNull(user, "Користувач не заданий!");
        Objects.requireNonNull(user.getAge(), "Вік користувача не заданий!");
        Objects.requireNonNull(user.getId(), "Id користувача не задано!");
        Objects.requireNonNull(user.getFirstName(), "Ім'я користувача не задано!");
        Objects.requireNonNull(user.getLastName(), "Прізвище користувача не задано!");

        if (user.getAge() <= 0) {
            throw new IllegalArgumentException("Вік користувача не може бути від'ємним!");
        }
        if (user.getAge() >= 126) {
            throw new IllegalArgumentException("Максимальний вік, до якого дожила людина - 126 років!");
        }
    }

    public User updateUser(Integer userId, User user) {
        Objects.requireNonNull(userId, "Id користувача, якого треба оновити не задано!");
        checkUser(user);
        if (usersMapper.ifUserExists(userId)) {
            return usersMapper.updateUser(userId, user);
        }
        throw new IllegalArgumentException("Користувача за id не знайдено!");
    }

    public Boolean deleteUserById(Integer id) {
        Objects.requireNonNull(id, "Id користувача, якого треба видалити не задано!");
        if (usersMapper.ifUserExists(id)) {
            return usersMapper.deleteUserById(id);
        }
        throw new IllegalArgumentException("Даного користувача за id не знайдено!");
    }
}
