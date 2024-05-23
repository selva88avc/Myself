package com.stackroute.restsample.model;

import com.stackroute.restsample.validator.Country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Passenger {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	String passengerid;
	@Column(name="passengername",nullable=false)
	String passengerName;
	@NotEmpty(message="fligh name cant be null")
	String flight;
	@Min(100)
	int fare;
	
	@Valid
	@Pattern(regexp="(BusinessClass|EconomicClass)",message="seattype should be BusinessClass or EconomicClass")
	String seattype;
	
	
	@Country
	@NotEmpty(message="please enter country name")
	String country;
	
	public String getSeattype() {
		return seattype;
	}
	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}

	public String getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(String passengerid) {
		this.passengerid = passengerid;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	

}
