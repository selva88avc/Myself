package com.stackroute.ThreadAsync;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MonthlyInstall implements Runnable
{

	public void run() {
	 System.out.println("Montly installments are caluclcated " + LocalDateTime.now()) ;
		
	}
	
}


class InterestUpdate implements Runnable
{

	public void run() {
		 System.out.println("Interest for amount is done " + LocalDateTime.now());
		
	}
	
}
public class ScheduleSample {

	public static void main(String[] args) {
	
		
		ScheduledExecutorService scheduleobj=Executors.newScheduledThreadPool(3);
		
		scheduleobj.scheduleAtFixedRate(new MonthlyInstall() , 0, 2, TimeUnit.SECONDS);
		scheduleobj.scheduleAtFixedRate(new InterestUpdate(), 0, 1, TimeUnit.MINUTES);
		

	}

}
