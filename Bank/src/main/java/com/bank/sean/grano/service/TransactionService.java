package com.bank.sean.grano.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sean.grano.dao.TransactionDAO;
import com.bank.sean.grano.dto.Transaction;

@Service
@Transactional
public class TransactionService {
	@Autowired
	TransactionDAO transactionD;

	// gets all the transactions for that account
	public List<Transaction> findAllTransactionByAccountid(int accountId) {
		try {
			return transactionD.findFirst5ByAccountIdOrderByTransDateDesc(accountId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// calculated the total amount of transactions for that account
	public float totalTransactions(int accountId) {
		try {
			List<Transaction> trans = findAllTransactionByAccountid(accountId);
			float total = 0.00f;
			for (Transaction t : trans) {
				total = total + t.getAmount();
			}
			return total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0f;
	}

	// creates a new transaction
	public void addTransaction(Transaction transaction) {
		transactionD.save(transaction);
	}

}
