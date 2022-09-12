package com.app.ezride.controllers;


import com.app.ezride.pojo.Ride;
import com.app.ezride.service.impl.RideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private RideServiceImpl rideService;
    
    /*
	 * URL:http://localhost:8050/driver/add_rides/1
	 * Payload:{
    "source": "Pune",
    "destination": "Mumbai",
    "date": "2022-07-07",
    "time": "20:24:00",
    "charges": 500,
    "capacity" : 4
}
	 */
    @PostMapping("/add_rides/{driver_id}")
    public ResponseEntity<String> addRides(@RequestBody Ride ride, @PathVariable(name = "driver_id") int driverId){
        rideService.addRides(ride, driverId);
        return new ResponseEntity<>("Ride added successfully", HttpStatus.OK);
    }
    /*
	 * URL:http://localhost:8050/driver/delete_rides/1/1
	 * */
    @DeleteMapping("/delete_rides/{ride_id}/{driver_id}")
    public ResponseEntity<String> deleteRide(@PathVariable (name = "ride_id") int rideID, @PathVariable (name = "driver_id") int driverId){
        rideService.deleteRide(rideID, driverId);
        return new ResponseEntity<>("Ride deleted successfully", HttpStatus.OK);
    }

}
