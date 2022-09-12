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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Ride> rideList = new ArrayList<>();

    public Customer(User user) {
        this.user = user;
    }


    // Helper methods

    public void addRide(Ride ride){
        this.rideList.add(ride);
        ride.setCustomerId(this);
    }

    public void deleteRide(Ride ride){
        this.rideList.remove(ride);
        ride.setCustomerId(null);
    }

}
