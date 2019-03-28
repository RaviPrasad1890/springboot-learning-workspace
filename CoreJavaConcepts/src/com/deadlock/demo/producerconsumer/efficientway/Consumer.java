package com.deadlock.demo.producerconsumer.efficientway;

public class Consumer extends Thread {

	Producer prod;
	
	Consumer(Producer prod){
		this.prod=prod;
	}
	
	public void run() {
		
		synchronized(prod.sb) {
			try {
				prod.sb.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(prod.sb);
		}
	}
}
