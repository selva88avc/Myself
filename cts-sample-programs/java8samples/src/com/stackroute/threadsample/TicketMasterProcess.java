package com.stackroute.threadsample;

class TicketMaster
{
	int ticketcount=10;
	public synchronized void ticketProcess(String type,int qty)
	{
		synchronized(this)
		{
		if (type.equals("reserve"))
		{
			 for (int i=1;i<=qty;i++)
			 {
				 ticketcount--;
				 
				 System.out.println("reserved , current count " + ticketcount);
				 try
				 {
					 Thread.sleep(1000);
				 }
				 catch(Exception e) {}
			 }
		}
		else if (type.equals("cancel"))
		{
			 for (int i=1;i<=qty;i++)
			 {
				 ticketcount++;
				 
				 System.out.println("cancelled , current count " + ticketcount);
				 try
				 {
					 Thread.sleep(1000);
				 }
				 catch(Exception e) {}
			 }
		}
		}
		
	}
	
	
}



class Reservation extends Thread
{
	TicketMaster tmaster;
	int qty;
	Reservation(TicketMaster t,int qt)
	{
		tmaster=t;
		qty=qt;
	}
	public void run()
	{
		tmaster.ticketProcess("reserve",qty );
	}
}

class Cancellation extends Thread
{
	
	
	TicketMaster  tmaster;
	int qty;
	Cancellation(TicketMaster  t,int qt)
	{
		tmaster=t;
		qty=qt;
	}
	public void run()
	{
		tmaster.ticketProcess("cancel",qty );
	}
}



public class TicketMasterProcess {
	
	public static void main(String arr[])
	{
		TicketMaster tmasterobj=new TicketMaster();
		Reservation reserve=new Reservation(tmasterobj,3);
		Reservation reserve1=new Reservation(tmasterobj,2);
		Cancellation cancel=new Cancellation(tmasterobj,2);
		reserve.start();
		reserve1.start();
		cancel.start();
	}
	

}



