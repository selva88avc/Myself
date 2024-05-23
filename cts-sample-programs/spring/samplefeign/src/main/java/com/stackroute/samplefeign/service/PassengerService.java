package com.stackroute.samplefeign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.samplefeign.model.Passenger;

@FeignClient("restsample")
public interface PassengerService {

	@RequestMapping(method=RequestMethod.GET,value="/passenger/viewall")
	public List<Passenger> getpass();

}
