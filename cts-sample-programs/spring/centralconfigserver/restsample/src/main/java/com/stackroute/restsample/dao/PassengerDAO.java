package com.stackroute.restsample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.restsample.model.Passenger;

@Repository
public interface PassengerDAO extends JpaRepository<Passenger,String>{
	
 
//	List<Passenger> findByFlight(String flight);
	
	List<Passenger> findByFlightAndSeattype(String flight,String seattype);
	
	Passenger		findByPassengerName(String pname);
	
	List<Passenger> findByFareLessThan(int amount);
	
	
	
	   @Query("SELECT b FROM Passenger b WHERE b.flight=:flight")
	    List<Passenger> findByflightName(@Param("flight") String flight);
	   
	   

}
