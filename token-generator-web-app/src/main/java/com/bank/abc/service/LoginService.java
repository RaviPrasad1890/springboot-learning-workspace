package com.bank.abc.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name, String password) {

		return name.equalsIgnoreCase("ravi") && password.equalsIgnoreCase("ravi");
	}

}
