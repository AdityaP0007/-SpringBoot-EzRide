package com.app.ezride.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private long mobileNumber;

    @Column(unique = true, nullable = false)
    private String email;
    private long aadhar;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name, long mobileNumber, String email, long aadhar, String password, Role role) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.aadhar = aadhar;
        this.password = password;
        this.role = role;
    }
}
