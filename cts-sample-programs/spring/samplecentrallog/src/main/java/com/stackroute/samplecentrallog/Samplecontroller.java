package com.stackroute.samplecentrallog;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Samplecontroller {
	
	Logger logs=LoggerFactory.getLogger(Samplecontroller.class);
	@GetMapping("/employee/{id}")
		public Employee getData(@PathVariable int id)
	{
		List<Employee> employees=getData();
		
		Employee emp=employees.stream().filter( (empob)->empob.getId()==id).findAny().orElse(null);
		
		if(emp!=null)
		{
			logs.info("user found " + id );
		}
		else
		{
			 try
			 {
				 throw new Exception();
				 
			 }
			 catch(Exception e)
			 {
				 logs.error("User not found " + id );
			 }
		}
		return new Employee();
	}
	

	
	
	public List<Employee> getData()
	{
		List<Employee> employees=new ArrayList();
		employees.add(new Employee(10,"Raj"));
		employees.add(new Employee(20,"Rahim"));
		return employees;

	}
}
