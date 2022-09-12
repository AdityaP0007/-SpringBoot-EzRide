package com.app.ezride.repositories;

import com.app.ezride.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmailAndPassword(String email, String password);

    public List<User> findByRole(String role);
}
