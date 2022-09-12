package com.app.ezride.service.impl;

import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.Driver;
import com.app.ezride.pojo.User;
import com.app.ezride.pojo.VehicleType;
import com.app.ezride.repositories.DriverRepo;
import com.app.ezride.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class DriverServiceImpl implements IDriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Override
    public void addDriver(UserDto userDto, User user) {
        Driver driver = new Driver(userDto.getDriverDto().getVehicleNumber(), userDto.getDriverDto().getVehicleType(), userDto.getDriverDto().getVehicleName(), userDto.getDriverDto().getCapacity(), user);
        driverRepo.save(driver);
    }

}
