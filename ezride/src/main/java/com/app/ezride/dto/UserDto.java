package com.app.ezride.dto;

import com.app.ezride.pojo.Role;
import com.app.ezride.pojo.User;
import com.app.ezride.pojo.VehicleType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private long mobileNumber;
    private String email;
    private long aadhar;
    private String password;
    private Role role;
    private DriverDto driverDto;
}
