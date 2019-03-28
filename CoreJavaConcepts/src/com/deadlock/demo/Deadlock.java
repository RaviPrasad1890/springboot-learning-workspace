package com.deadlock.demo;

public class Deadlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Object train= new Object();
		
		Object compartment = new Object();
		
		BookTicket obj1= new BookTicket(train,compartment);
		CancelTicket obj2= new CancelTicket(train,compartment);
		
		//attach two threads to do jobs
		
		Thread t1= new Thread(obj1);
		
		Thread t2= new Thread(obj2);
		
		t1.start();
		t2.start();
	}

}
