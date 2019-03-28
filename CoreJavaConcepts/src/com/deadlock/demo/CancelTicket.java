package com.deadlock.demo;

public class CancelTicket extends Thread {

	Object train;
	Object comp;
	public CancelTicket(Object train, Object comp) {
		this.train = train;
		this.comp = comp;
	}
	
	
	public void run() {
		//lock on train
		synchronized(comp) {
			System.out.println("CancelTicket got lock on comp object");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("CancelTicket now waiting to get lock on train object");
			
			synchronized(train) {
				System.out.println("CancelTicket got lock of train object");
			}
		}
	}
}
