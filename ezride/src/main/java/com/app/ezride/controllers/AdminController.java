package com.app.ezride.controllers;

import com.app.ezride.dto.DriverDto;
import com.app.ezride.dto.UserDto;
import com.app.ezride.pojo.Ride;
import com.app.ezride.pojo.User;
import com.app.ezride.service.impl.AdminServiceImpl;
import com.app.ezride.service.impl.RideServiceImpl;
import com.app.ezride.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main_admin")
public class AdminController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private AdminServiceImpl adminService;

	@Autowired
	private RideServiceImpl rideService;

	/*
	 * URL:http://localhost:8050/main_admin/add_admin
	 *  Payload:{ "name" : "xyz",
	 *             "mobileNumber" : "45884", 
	 *             "email" : "xyz@gamil.com", 
	 *             "aadhar" : "123145",
	 *              "password" : "gsdfdf", 
	 *              "role" : "ADMIN" 
	 *              }
	 */
	@PostMapping("/add_admin")
	public ResponseEntity<String> addAdmin(@RequestBody UserDto userDto) {
		User user = null;
		if (userDto.getRole().toString().equals("ADMIN")) {
			user = userService.addUser(userDto);
		}
		adminService.addAdmin(user);
		return new ResponseEntity<>("Admin added successfully", HttpStatus.OK);
	}

	/*
	 * URL:http://localhost:8050/main_admin/get_all_drivers Payload:
	 */
	@GetMapping("/get_all_drivers")
	public ResponseEntity<List<DriverDto>> getAllDrivers() {
		List<DriverDto> list = adminService.getLitOfDrivers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/*
	 * URL:http://localhost:8050/main_admin/get_all_customer Payload:
	 */
	@GetMapping("/get_all_customer")
	public ResponseEntity<List<User>> getAllCustomers() {
		List<User> list = adminService.getUserList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/*
	 * URL:http://localhost:8050/main_admin/get_all_admin Payload:
	 */
	@GetMapping("/get_all_admin")
	public ResponseEntity<List<User>> getAllAdmin() {
		return new ResponseEntity<>(adminService.getAdminList(), HttpStatus.OK);
	}

	/*
	 * URL:http://localhost:8050/main_admin/get_all_rides Payload:
	 */
	@GetMapping("/get_all_rides")
	public ResponseEntity<List<Ride>> getAllRides() {
		return new ResponseEntity<>(rideService.getAlRides(), HttpStatus.OK);
	}

	/*
	 * URL:http://localhost:8050/main_admin/delete_rides/2/3 Payload:
	 */
	@DeleteMapping("/delete_rides/{ride_id}/{driver_id}")
	public ResponseEntity<String> deleteRide(@PathVariable(name = "ride_id") int rideID,
			@PathVariable(name = "ride_id") int driverId) {
		rideService.deleteRide(rideID, driverId);
		return new ResponseEntity<>("Ride deleted successfully", HttpStatus.OK);
	}

}
