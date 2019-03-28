package com.bank.abc.service;

import org.springframework.data.repository.CrudRepository;

import com.bank.abc.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
