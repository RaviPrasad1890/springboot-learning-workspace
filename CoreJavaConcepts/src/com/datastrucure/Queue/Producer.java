package com.datastrucure.Queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;
	
	
	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}


	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				Message msg= new Message(i+" ");
				queue.put(msg);
				Thread.sleep(i);
			}catch(InterruptedException e) {}
		}

		//Putting exit message
		Message msg= new Message("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
