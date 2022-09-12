package com.app.ezride.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String vehicleName;

    private int capacity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "driverId", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Ride> rideList = new ArrayList<>();

    public Driver(String vehicleNumber, VehicleType vehicleType, String vehicleName, int capacity, User user) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.user = user;
    }

    // Helper methods

    public void addRide(Ride ride){
        this.rideList.add(ride);
        ride.setDriverId(this);
    }

    public void deleteRide(Ride ride){
        this.rideList.remove(ride);
        ride.setDriverId(null);
    }

}

