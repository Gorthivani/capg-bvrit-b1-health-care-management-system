package com.capg.hcms.healthcaremanagementsystem.controller;


import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.capg.hcms.healthcaremanagementsystem.model.Appointment;
import com.capg.hcms.healthcaremanagementsystem.model.AppointmentList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenter;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenterList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTest;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTestList;
import com.capg.hcms.healthcaremanagementsystem.model.User;
import com.capg.hcms.healthcaremanagementsystem.model.UserList;
import com.capg.hcms.healthcaremanagementsystem.service.IHealthCareService;

@RestController
@RequestMapping("/hcms")
public class HealthCareController {

	@Autowired
	private IHealthCareService service;
	
	@PostMapping("/addcenter")
	public DiagnosticCenter addCenter(@RequestBody DiagnosticCenter center)
	{
		return service.addCenter(center);
	}
	
	@DeleteMapping("/removecenter")
	public boolean removeCenter(@RequestBody DiagnosticCenter center)
	{
		System.out.println("inhealthcareController");
		return service.removeCenter(center);
	}
	
	@DeleteMapping("/removetest/{centerId}")
	public boolean removeTest(@RequestBody DiagnosticTest test,@PathVariable String centerId) throws RestClientException, URISyntaxException
	{
		return service.removeTest(centerId,test);
	}
	
	@PostMapping("/addtest/{centerId}")
	public DiagnosticTest addTest(@PathVariable String centerId,@RequestBody DiagnosticTest test) throws RestClientException, URISyntaxException
	{
		return service.addTest(centerId, test);
	}
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}
	
	@PostMapping("/makeappointment/{centerId}")
	public Appointment makeAppointment(@PathVariable String centerId,@RequestBody Appointment appointment) throws RestClientException, URISyntaxException
	{
	    return service.makeAppointment(centerId,appointment);	
	}
	
	@PutMapping("/approveappointment/{appointmentId}/{status}")
	public Appointment approveAppointment(@PathVariable BigInteger appointmentId,@PathVariable boolean status)
	{
		return service.approvementAppointment(appointmentId, status);
	}
	
	@GetMapping("/getallcenters")
	public DiagnosticCenterList getAllCenters()
	{
		  return service.getAllCenters();
	}
	
	@GetMapping("/getalltests")
	public DiagnosticTestList getAllTests()
	{
		  return service.getAllTests();
	}
	
	@GetMapping("/getallappointments")
	public AppointmentList getAllAppointments()
	{
		  return service.getAllAppointments();
	}
	
	@GetMapping("/getallusers")
	public UserList getAllUsers()
	{
		  return service.getAllUsers();
	}
}