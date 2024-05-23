package com.stackroute.streamsample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeProcess {

	public static void main(String[] args) {
 
		
		LocalDate today=LocalDate.now();
		
		
		LocalDate birthday=LocalDate.of(2004, 12, 20);
		
   //System.out.println(birthday)	;
  
   //System.out.println(birthday.plusYears(5))	;
   
   DateTimeFormatter custom=DateTimeFormatter.ofPattern("dd/MM/yyyy");
   //System.out.println(today.format(custom));

   LocalDate dt=birthday.with(TemporalAdjusters.firstDayOfNextMonth());
  // System.out.println(dt);
   
   
   LocalDate dtsun=today.plusWeeks(3).with(DayOfWeek.SUNDAY);
   
 //  System.out.println(dtsun);
   
   
   LocalDate firstday=today.with(TemporalAdjusters.firstDayOfNextMonth());
   
  // 	IntStream.iterate(1,i->i+1).limit(30).boxed().collect(Collectors.toList()).forEach(System.out::println);
   	
   	IntStream.iterate(1,i->i+1).limit(28).mapToObj( num-> firstday.plusDays(num) )
   				.filter( dt1-> dt1.getDayOfWeek().toString().equals("SUNDAY"))
   				.collect(Collectors.toList()).forEach(System.out::println);
   	
   	List<Employee> employees=Arrays.asList(new Employee("Dan",LocalDate.of(2000, 10, 20),LocalDate.of(2023, 5, 10)),
   			new Employee("Arun",LocalDate.of(1994, 05, 22),LocalDate.of(2020, 7, 10)),
   			new Employee("Sundar",LocalDate.of(1965, 10, 21),LocalDate.of(2005, 5, 20)));
   	
  Optional<Employee> optemp=	employees.stream().min(Comparator.comparing(Employee::getDoj));
  
    if (optemp.isPresent())
    	System.out.println(optemp.get());
   	
	
	
	LocalDate scheme=LocalDate.of(2020, 10, 20);
	
	employees.forEach(
			
					emp->
					{
							if(emp.getDoj().isAfter(scheme))
								System.out.println("Not Eligible for Pension " + emp.getName());
							else
								System.out.println("Eligible for pension " + emp.getName());
					}
			
			
			);
	
		Period diff=Period.between(birthday, today);
		//System.out.println(diff);
	
		// list of employees , who are having > 10 years of experience
		
		
		employees.forEach( emp->{
			
				Period pday=Period.between(emp.getDoj(), today);
				if (pday.getYears()>=10)
					System.out.println(emp);
			
		});
		
//		employees.stream().filter( a-> { Period pday=Period.between(emp.getDoj(), today);
//										return (pday.getYears()>=10);}).
		
}

}
