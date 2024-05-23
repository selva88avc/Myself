package com.stackroute.restsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.restsample.config.CustomResponseHandler;
import com.stackroute.restsample.exception.IdAlreadyExistException;
import com.stackroute.restsample.exception.IdNotFoundException;
import com.stackroute.restsample.model.Passenger;
import com.stackroute.restsample.service.PassengerService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	PassengerService passenservice;
	@GetMapping("/viewall")
	public ResponseEntity<?> getpassenger()
	{
	List<Passenger> passengers=	passenservice.getPassengers();
	//return new ResponseEntity<List>(passengers,HttpStatus.OK);
	return CustomResponseHandler.generateResponse("Data Retrieved successully", HttpStatus.OK, passengers);
	}
	@PostMapping("/addpassenger")
	public ResponseEntity<?> addpassenger(@Valid @RequestBody Passenger passenger)
	{
	try {
		Passenger storedpasseng=passenservice.addPassenger(passenger);
		return new ResponseEntity<Passenger>(storedpasseng,HttpStatus.CREATED);
	}
	catch (IdAlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
	}
	}
	
	
	
	
	
	
//	@PostMapping("/addpassenger")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Passenger addPasseng(@Valid @RequestBody Passenger passenger) throws IdAlreadyExistException
//	{
//		Passenger storedpasseng=passenservice.addPassenger(passenger);
//		return storedpasseng;
//	}
//	
//	
	
	@DeleteMapping("/removePassenger/{passid}")
	public ResponseEntity<?> deleteuser(@PathVariable("passid") String passengerid) 
	{
		
	try {
		boolean result=passenservice.deletePassenger(passengerid);
		return new ResponseEntity<String>("successfuly deleted " ,HttpStatus.OK);
	} catch (IdNotFoundException e) {
		return new ResponseEntity<String>("Invalid Id" ,HttpStatus.NOT_FOUND);
	}
	
		
	}
	
	@GetMapping("/viewbyflight/{flight}")
	public ResponseEntity<?> viewflight(@PathVariable("flight") String flight)  
	{
	
		List<Passenger> passengers=passenservice.getPassengerByFlight(flight);
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewbyflightseat/{flight}/{seattype}")
	public ResponseEntity<?> viewflightbasedseat(@PathVariable("flight") String flightvar,@PathVariable("seattype") String seattype  )
	{
	
		List<Passenger> passengers=passenservice.getPassengerByFlighandseat(flightvar,seattype);
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewbycost/{price}")
	public ResponseEntity<?> viewbycost(@PathVariable("price") String pricevar)
	{
		int price=Integer.parseInt(pricevar);
		List<Passenger> passengers=passenservice.getPassengerWithMinPrice(price);
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
	}
	
	@PutMapping("/modifyPassenger")
	public ResponseEntity<?> updatepassenger(@RequestBody Passenger passenger) throws IdNotFoundException
	{
	Passenger updatedpassenger=	passenservice.updatePassenger(passenger);
		return new ResponseEntity<Passenger>(updatedpassenger,HttpStatus.OK);
	}
	

//	@GetMapping("/getdata")
//		public ResponseEntity<?> getalldata(@RequestParam(value="username") String uname)
////
//		{
// 	return new ResponseEntity<String>("Welcome " + uname ,HttpStatus.OK);
////
//		}
}
