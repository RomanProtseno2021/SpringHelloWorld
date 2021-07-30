package com.example.springhelloworld.controllers;

import com.example.springhelloworld.services.UsersService;
import com.example.springhelloworld.stucts.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Setter
    @Autowired
    private UsersService usersService;

    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = usersService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

}
