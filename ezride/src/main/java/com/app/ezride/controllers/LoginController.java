package com.app.ezride.controllers;


import com.app.ezride.pojo.User;
import com.app.ezride.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/get_user")
    public ResponseEntity<User> login(@RequestBody User user){
        User user1 =userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
}
