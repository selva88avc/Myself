package com.stackroute.restsample.service;

import java.util.List;

import com.stackroute.restsample.exception.IdAlreadyExistException;
import com.stackroute.restsample.exception.IdNotFoundException;
import com.stackroute.restsample.model.Passenger;

public interface PassengerService {

	List<Passenger> getPassengers();
	
	Passenger addPassenger(Passenger newpassenger) throws IdAlreadyExistException;
	
	boolean deletePassenger(String passid) throws IdNotFoundException;
	

	Passenger updatePassenger(Passenger passenger) throws IdNotFoundException;
	
	List<Passenger> getPassengerByFlight(String flight) ;
	
	List<Passenger> getPassengerByFlighandseat(String flight,String seattype);
	
	List<Passenger> getPassengerWithMinPrice(int price);
	
}
