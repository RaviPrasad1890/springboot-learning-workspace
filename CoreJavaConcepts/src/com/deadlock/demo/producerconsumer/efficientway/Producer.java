package com.deadlock.demo.producerconsumer.efficientway;

public class Producer extends Thread {

	StringBuffer sb;
	// boolean dataprodover=false;

	Producer() {
		sb = new StringBuffer();// allocating memory
	}

	public void run() {
		synchronized (sb) {
			for (int i = 1; i <= 10; i++) {

				try {
					sb.append(i + " ");
					Thread.sleep(150);
					System.out.println("Appnding");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			sb.notify();
		}
		// dataprodover=true;
	}
}
