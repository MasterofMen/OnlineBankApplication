package com.bank.sean.grano.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.sean.grano.dto.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	// Find user by Username
	User findByUsername(String username);

	// find User by id
	User findById(int id);

	// gets all usernames
	@Query("select username from User")
	List<String> findAllUsernames();
}
