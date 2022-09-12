package com.app.ezride.controllers;
import com.app.ezride.pojo.Ride;
import com.app.ezride.service.impl.RideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RideServiceImpl rideService;

    /*
	 * URL:http://localhost:8050/customer/get_rides
	 * Payload:
	 */
    @GetMapping("/get_rides")
    /***
     * PAYLOAD -> source, destination and proper date
     */
    public ResponseEntity<List> getRides(@RequestBody Ride ride){
        return new ResponseEntity<>(rideService.getRides(ride), HttpStatus.OK);
    }
    /*
	 * URL:http://localhost:8050/customer/book_rides/2?customerId=2&&numberOfSeats=4
	 * Payload:{
                "source": "Pune",
                "destination": "Mumbai",
                "date": "2022-07-07"
                }
	 */
    @PostMapping("/book_rides/{ride_id}")
    public ResponseEntity<String> bookRide(@PathVariable (name = "ride_id") int rideId, @RequestParam (name = "customerId") int customerId, @RequestParam(name = "numberOfSeats") int numberOfSeats){
        rideService.bookRide(rideId, customerId, numberOfSeats);
        return new ResponseEntity<>("Ride booked successfully", HttpStatus.OK);
    }




}
