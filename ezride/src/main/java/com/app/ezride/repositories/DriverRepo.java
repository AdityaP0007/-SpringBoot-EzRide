package com.app.ezride.repositories;

import com.app.ezride.pojo.Customer;
import com.app.ezride.pojo.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, Integer> {
}
