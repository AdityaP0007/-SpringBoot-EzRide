package com.app.ezride.service;

import com.app.ezride.pojo.Ride;

import java.util.List;

public interface IRideService {
    public void addRides(Ride ride, int driverId);

    public List<Ride> getRides(Ride ride);

    public void  bookRide (int id, int customerId, int numberOfSeats);
}
