package com.app.ezride.service.impl;

import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.Customer;
import com.app.ezride.pojo.User;
import com.app.ezride.repositories.CustomerRepo;
import com.app.ezride.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addCustomer(User user) {
        Customer customer = new Customer(user);
        customerRepo.save(customer);
    }
}
