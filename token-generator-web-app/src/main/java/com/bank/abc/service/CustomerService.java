package com.bank.abc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.abc.model.Counter;
import com.bank.abc.model.Customer;
import com.bank.abc.model.Token;

@Service
public class CustomerService {

	

    private static List<Customer> cust = new ArrayList<Customer>();
    private static List<Counter> primaryCounter = new ArrayList<Counter>();
    private static List<Counter> nonPrimaryCounter = new ArrayList<Counter>();
    private static int custCount = 3;
    private static int tokenCount = 0;
    private static int primCount=0;
    private static int nonPrimeCount=0;

    static {
        cust.add(new Customer(1, "CustomerOne", 'Y'));
        cust.add(new Customer(2, "CustomerTwo", 'N'));
        cust.add(new Customer(3, "CustomerThree", 'N'));
        primaryCounter.add(new Counter('Y',1));
        primaryCounter.add(new Counter('Y',2));
        nonPrimaryCounter.add(new Counter('N',3));
        nonPrimaryCounter.add(new Counter('N',4));
    }

    public Customer retrieveCustomer(int custId) {
    	
    	Customer cst=null;
    	//boolean flag=false;
        for (Customer customer : cust) {
            if(customer.getCustId()==custId) {
            	cst=customer;
            	//flag=true;
            	break;
            }
        }
       
        	return cst;
    }
    
	/*
	 * public Todo retrieveTodo(int id) { for (Todo todo : todos) { if
	 * (todo.getId()==id) { return todo; } } return null; }
	 */

    public void updateCustomerStatus(char isPrimary,int custId){
    	for(Customer customer:cust) {
    		if(customer.getCustId()==custId) {
    			if(customer.getPrimaryCustomer()!=isPrimary) {
    				String name=customer.getCustName();
    				cust.remove(customer);
    				cust.add(new Customer(custId,name,isPrimary));
    			}
    		}
    	}
    }

    public void addCustomer(String name, char isPriamry) {
        cust.add(new Customer(++custCount, name, isPriamry));//, targetDate, isDone));
    }

    public void deleteCustomer(int id) {
        Iterator<Customer> iterator = cust.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getCustId() == id) {
                iterator.remove();
            }
        }
    }
    
    public int assignToken(int custId) {
    	
    	for(Customer customer:cust) {
    		if (customer.getCustId() == custId) {
    			tokenCount++;
    			return tokenCount;
    		}
    	}
    	return 0;
    	
    }
    
    public Counter assignCounter(int custId) {
    	
    	if(primaryCounter.size()==primCount) {
    		primCount=0;
    	}
    	
    	if(nonPrimaryCounter.size()==nonPrimeCount) {
    		nonPrimeCount=0;
    	}
    	Counter ct=null;
    	
    	for(Customer customer:cust) {
    		if (customer.getCustId() == custId) {
    			if(customer.getPrimaryCustomer()=='Y') {
    				ct=primaryCounter.get(primCount);
    				primCount++;
    			}else {
    				ct=nonPrimaryCounter.get(nonPrimeCount);
    			}
    		}
    	}
    	return ct;
    }
    
    
    public Customer markTokenComplete(int custId) {
    	Customer newC = new Customer();
    	
    	for (Customer customer : cust) {
			if(customer.getCustId()==custId) {
				//if(customer.getToken().getNumber()==tokenId) {
					Token tkn=customer.getToken();
					tkn.setActive('N');
					customer.setToken(tkn);
					//customer.setToken(token);
				//}
				newC=customer;
				break;
			}
		}
    	
    	return newC;
    }

	public List<Customer> retrieveCustomers() {
		// TODO Auto-generated method stub
		return cust;
	}
    
    




}
