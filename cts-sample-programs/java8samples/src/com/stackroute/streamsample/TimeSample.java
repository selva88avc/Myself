package com.stackroute.streamsample;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSample {

	public static void main(String[] args) throws InterruptedException {
		LocalTime starttime = LocalTime.now();
		
		
		//Thread.sleep(3000);
		System.out.println("Recieved output ");
		
		LocalTime endtime=LocalTime.now();
		
		Duration duration=Duration.between(starttime, endtime);
		
		System.out.println(duration.getSeconds());
		
		System.out.println(endtime);
		
		DateTimeFormatter dtformat=DateTimeFormatter.ofPattern("HH:mm");
	//	System.out.println(endtime.format(dtformat));
		
		ZonedDateTime zoneobj=ZonedDateTime.now();
		
		System.out.println(zoneobj.getZone());
		
		ZoneId changedzone=ZoneId.of("Australia/Sydney");
		ZonedDateTime zoneobj1=ZonedDateTime.now(changedzone);
		
		System.out.println(zoneobj1);
		
		
	}

}
