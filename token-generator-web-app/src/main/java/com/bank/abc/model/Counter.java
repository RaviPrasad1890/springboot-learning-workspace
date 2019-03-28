package com.bank.abc.model;

public class Counter {

	char primaryCounter;
	int number;
	
	public Counter(){
		
	}

	public Counter(char primaryCounter, int number) {
		this.primaryCounter = primaryCounter;
		this.number = number;
	}

	public char getPrimaryCounter() {
		return primaryCounter;
	}

	public void setPrimaryCounter(char primaryCounter) {
		this.primaryCounter = primaryCounter;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Counter [primaryCounter=" + primaryCounter + ", number=" + number + "]";
	}
	
	
}
