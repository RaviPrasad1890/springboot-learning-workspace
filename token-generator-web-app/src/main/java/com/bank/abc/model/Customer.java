package com.bank.abc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bank.abc.model.Counter;
import com.bank.abc.model.Customer;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int custId;
	private String custName;
	private char primaryCustomer;
	private Token token;	

	
	private Customer() {
		
	}

	public Customer(int custId, String custName, char primaryCustomer) {
		this.custId = custId;
		this.custName = custName;
		this.primaryCustomer = primaryCustomer;
		//this.tokenAssigned = tokenAssigned;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public char getPrimaryCustomer() {
		return primaryCustomer;
	}

	public void setPrimaryCustomer(char primaryCustomer) {
		this.primaryCustomer = primaryCustomer;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", primaryCustomer=" + primaryCustomer
				+ ", token=" + token + "]";
	}

	
	
	


}
