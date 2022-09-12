package com.app.ezride.service;

import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.User;

import java.util.List;

public interface IUserService {
    public User addUser(UserDto user);

    public User findByEmailAndPassword(String email, String password);

    public List<User> findByRole(String role);
}
