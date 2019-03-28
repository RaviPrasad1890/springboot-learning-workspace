package com.deadlock.demo.producerconsumer.inefficientway;

public class Consumer extends Thread {

	Producer prod;
	
	Consumer(Producer prod){
		this.prod=prod;
	}
	
	public void run() {
		
		try {
		while(!prod.dataprodover) {
				Thread.sleep(10);
			} 
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//When data production is over, display it
		System.out.println(prod.sb);
	}
}
