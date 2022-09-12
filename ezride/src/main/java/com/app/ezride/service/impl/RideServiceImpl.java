package com.app.ezride.service.impl;

import com.app.ezride.pojo.Customer;
import com.app.ezride.pojo.Driver;
import com.app.ezride.pojo.Ride;
import com.app.ezride.repositories.CustomerRepo;
import com.app.ezride.repositories.DriverRepo;
import com.app.ezride.repositories.RideRepo;
import com.app.ezride.service.IRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RideServiceImpl implements IRideService {

    @Autowired
    private RideRepo rideRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addRides(Ride ride, int driverId) {
        Driver driver = driverRepo.getById(driverId);
        driver.addRide(ride);
        rideRepo.save(ride);
    }

    @Override
    public List<Ride> getRides(Ride ride) {
        List<Ride> list = new ArrayList<>();
        List<Ride> mainList =  rideRepo.findAll();
        System.out.println(mainList);
        for(int i=0; i<mainList.size(); i++){
            if(mainList.get(i).getSource().equals(ride.getSource()) &&mainList.get(i).getDestination().equals(ride.getDestination()) && mainList.get(i).getDate().equals(ride.getDate())){
                System.out.println("Inside if");
                list.add(mainList.get(i));
            }
        }
        return list;
    }

    @Override
    public void bookRide(int id, int customerId, int numberOfSeats) throws RuntimeException{
        int seats;
        Ride ride = rideRepo.findById(id).orElseThrow(()-> new RuntimeException("Ride not found"));
        if (ride.getCapacity() >0) {
            seats = ride.getCapacity() - numberOfSeats;
            if (seats < 0){
                throw new RuntimeException("Invalid seats request");
            }else{
                ride.setCapacity(seats);
            }
        }
        Customer customer = customerRepo.findById(customerId).orElseThrow(()-> new RuntimeException("Customer not found"));
        customer.addRide(ride);
    }

    public void deleteRide(int rideId, int driverId){
        Driver driver = driverRepo.findById(driverId).orElseThrow(()->new RuntimeException("Driver not found"));
        Ride ride = rideRepo.findById(rideId).orElseThrow(()->new RuntimeException("Ride not found"));
        driver.deleteRide(ride);
    }

    public List<Ride> getAlRides(){
        return rideRepo.findAll();
    }
}
