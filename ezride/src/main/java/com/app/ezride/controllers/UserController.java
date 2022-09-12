package com.app.ezride.controllers;


import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.User;
import com.app.ezride.service.impl.CustomerServiceImpl;
import com.app.ezride.service.impl.DriverServiceImpl;
import com.app.ezride.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CustomerServiceImpl customerService;


    @Autowired
    private DriverServiceImpl driverService;

    /*
	 * URL:http://localhost:8050/user/add_user
       Payload:{ "name" : "xyz",
	 *             "mobileNumber" : "45884", 
	 *             "email" : "xyz@gamil.com", 
	 *             "aadhar" : "123145",
	 *              "password" : "gsdfdf", 
	 *              "role" : "CUSTOMER" 
	 *              }
	 *              
	 *              OR
	 * Payload:{
               "name": "abc",
               "mobileNumber": "98096",
               "email": "abc@gamil.com",
               "aadhar": "127345",
               "password": "asdfafs",
                "role": "DRIVER",
                "driverDto": {
                        "vehicleNumber": "1232",
                        "vehicleType": "SUV",
                        "vehicleName": "KIA",
                        "capacity": 4
    }
}

	 */
    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        User user = userService.addUser(userDto);
        if (user.getRole().toString().equals("CUSTOMER")){
            customerService.addCustomer(user);
        }
        if (user.getRole().toString().equals("DRIVER")){
            driverService.addDriver(userDto,user);
        }
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

}
