package com.app.ezride.repositories;

import com.app.ezride.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
