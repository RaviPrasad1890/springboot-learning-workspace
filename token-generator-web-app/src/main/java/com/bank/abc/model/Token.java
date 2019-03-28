package com.bank.abc.model;

public class Token {
	private int number;
	private char active;
	private Counter counter;

	
	
	
	
	private Token() {
		
	}

	public Token(int number, char active, Counter counter) {//, Customer customer) {
		this.number = number;
		this.active = active;
		this.counter = counter;
		//this.customer = customer;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public char getActive() {
		return active;
	}
	public void setActive(char active) {
		this.active = active;
	}
	public Counter getCounter() {
		return counter;
	}
	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "Token [number=" + number + ", active=" + active + ", counter=" + counter + "]";
	}

	/*
	 * public Customer getCustomer() { return customer; } public void
	 * setCustomer(Customer customer) { this.customer = customer; }
	 */
	
	
	

}
