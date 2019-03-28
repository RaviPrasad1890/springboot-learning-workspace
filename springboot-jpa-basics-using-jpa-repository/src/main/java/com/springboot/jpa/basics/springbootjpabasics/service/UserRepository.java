package com.springboot.jpa.basics.springbootjpabasics.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.basics.springbootjpabasics.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
/*
 * We can also extends Interface JpaRepository
 */
	 List<User> findByRole(String description);
	 //we can define such methods to get users by role, no need to implement it, 
	 //spring will take care
}
