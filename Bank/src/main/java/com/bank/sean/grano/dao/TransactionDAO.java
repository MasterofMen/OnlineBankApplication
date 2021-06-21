package com.bank.sean.grano.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.sean.grano.dto.Transaction;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Integer> {
	// get 5 transactions by desc order by date of transaction
	List<Transaction> findFirst5ByAccountIdOrderByTransDateDesc(int accountId);
}
