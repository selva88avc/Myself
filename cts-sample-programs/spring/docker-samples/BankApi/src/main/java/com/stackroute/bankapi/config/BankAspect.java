package com.stackroute.bankapi.config;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class BankAspect {
	
	Logger log=LoggerFactory.getLogger(BankAspect.class);

	
	@Around("execution(* com.stackroute.bankapi.controller.BankController.addAccount(..))")
	public Object aroundregis(ProceedingJoinPoint prc) throws Throwable
	{
		Object obj=prc.proceed();
		
		try
		{
			log.info("A new user is getting added" + obj.toString() + " on " + LocalDateTime.now());
		}
		catch(Exception e)
		{
			
		}
		return obj;
	}
	
	@After("execution(* com.stackroute.bankapi.controller.BankController.addAccount(..))")
	public void aftercallingreg(JoinPoint jp)
	
	{
		
		log.info("user inserted");
		
	}
	

}
