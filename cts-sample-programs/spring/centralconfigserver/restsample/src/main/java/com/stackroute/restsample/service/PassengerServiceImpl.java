package com.stackroute.restsample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.restsample.dao.PassengerDAO;
import com.stackroute.restsample.exception.IdAlreadyExistException;
import com.stackroute.restsample.exception.IdNotFoundException;
import com.stackroute.restsample.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	PassengerDAO passengerdao;
	
	
	@Override
	public List<Passenger> getPassengers() {
		
		return passengerdao.findAll();
	}

	@Override
	public Passenger addPassenger(Passenger newpassenger) throws IdAlreadyExistException {
		
	Optional<Passenger> passopt=passengerdao.findById(newpassenger.getPassengerid());
		
	if(passopt.isPresent())
		throw new IdAlreadyExistException("Duplicate passenger ID");
 	
		
	Passenger passadded=	passengerdao.save(newpassenger);
		return passadded;
	
	}

	@Override
	public boolean deletePassenger(String passid) throws IdNotFoundException {
		
	Optional<Passenger> passopt=passengerdao.findById(passid);
		
	if(passopt.isPresent())
	{
		passengerdao.deleteById(passid);
		return true;
	}
	else
		throw new IdNotFoundException("Invalid id");
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) throws IdNotFoundException {
		Optional<Passenger> passopt=passengerdao.findById(passenger.getPassengerid());
		
		if(passopt.isPresent())
		{
			Passenger passadded=	passengerdao.save(passenger);
			return passadded;
		}
		else
			throw new IdNotFoundException("Id not found");
		
			
	
			
	}

	@Override
	public List<Passenger> getPassengerByFlight(String flight) {
 
		return passengerdao.findByflightName(flight);
	}

	@Override
	public List<Passenger> getPassengerByFlighandseat(String flight, String seattype) {
  
		return passengerdao.findByFlightAndSeattype(flight, seattype);
	}

	@Override
	public List<Passenger> getPassengerWithMinPrice(int price) {

		return passengerdao.findByFareLessThan(price);
	}

}
