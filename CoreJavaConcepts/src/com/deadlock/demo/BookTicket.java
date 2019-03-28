package com.deadlock.demo;

public class BookTicket extends Thread {

	Object train;
	Object comp;
	public BookTicket(Object train, Object comp) {
		this.train = train;
		this.comp = comp;
	}
	
	public void run() {
		//lock on train
		synchronized(train) {
			System.out.println("BookTicket got lock on train object");
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("BookTicket now witing to get lock on comp object");
			
			synchronized(comp) {
				System.out.println("BookTicket got lock of comp object");
			}
		}
	}
}
