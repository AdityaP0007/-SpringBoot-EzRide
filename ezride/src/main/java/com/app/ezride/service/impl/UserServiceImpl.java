package com.app.ezride.service.impl;

import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.Role;
import com.app.ezride.pojo.User;
import com.app.ezride.repositories.UserRepo;
import com.app.ezride.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User addUser(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getMobileNumber(), userDto.getEmail(), userDto.getAadhar(), userDto.getPassword(), userDto.getRole());
        userRepo.save(user);
        return user;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        if(user == null){
            throw new RuntimeException("User not found");
        }
        return user;
    }

    @Override
    public List<User> findByRole(String role) {  // HIBERNATE Bug
        List <User> userList = userRepo.findByRole(role);
        return  userList;
    }
}
