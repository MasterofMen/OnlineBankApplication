package com.bank.sean.grano.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.sean.grano.dto.Account;

@Repository
public interface AccountDAO extends CrudRepository<Account, Integer> {
	// find Account by userId
	Account findByUserId(int id);

	// find Account by accountId
	Account findByAccountId(int id);

	// deletes Account by userId
	void deleteByuserId(int id);
}
