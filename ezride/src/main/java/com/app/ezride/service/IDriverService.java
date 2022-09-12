package com.app.ezride.service;

import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.User;

public interface IDriverService {
    public void addDriver(UserDto userDto, User user);
}
