package com.app.ezride.dto;

import com.app.ezride.pojo.Role;
import com.app.ezride.pojo.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class DriverDto {

    private String name;
    private long mobileNumber;
    private String email;
    private long aadhar;
    private String password;
    private Role role;




    private String vehicleNumber;

    private VehicleType vehicleType;

    private String vehicleName;

    private int capacity;

}
