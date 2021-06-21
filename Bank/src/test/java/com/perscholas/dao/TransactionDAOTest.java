package com.perscholas.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.sean.grano.dao.TransactionDAO;
import com.bank.sean.grano.dto.Transaction;

class TransactionDAOTest {

	TransactionDAO transD;
	Date date = new Date();

	@BeforeEach
	void setUp() {
		transD = mock(TransactionDAO.class);
		when(transD.findFirst5ByAccountIdOrderByTransDateDesc(1)).thenReturn(mockList());
		when(transD.save(mockTransaction())).thenReturn(new Transaction(1, 200, date, "Debit", 5000, "Gas money", 1));
	}

	@Test
	public void testFindFirst5ByAccountIdOrderByTransDateDesc() {
		List<Transaction> trans = transD.findFirst5ByAccountIdOrderByTransDateDesc(1);
		for (int i = 0; i < trans.size(); i++) {
			assertEquals(trans.get(i), mockList().get(i));
		}
	}

	@Test
	public void testSaveTransaction() {
		Transaction transaction = transD.save(mockTransaction());
		Transaction transaction2 = mockTransaction();
		transaction2.setTransactionId(1);
		assertEquals(transaction, transaction2);
	}

	Transaction mockTransaction() {
		Transaction transaction = new Transaction();
		transaction.setAccountId(1);
		transaction.setAmount(200);
		transaction.setBalance(5000);
		transaction.setDescription("Gas money");
//		transaction.setTransactionId(1);
		transaction.setType("Debit");
		transaction.setTransDate(date);
		return transaction;
	}

	List<Transaction> mockList() {
		Transaction trans1 = mockTransaction();
		trans1.setTransactionId(1);
		Transaction trans2 = mockTransaction();
		trans2.setTransactionId(2);
		Transaction trans3 = mockTransaction();
		trans3.setTransactionId(3);
		List<Transaction> trans = new ArrayList<Transaction>();
		trans.add(trans3);
		trans.add(trans2);
		trans.add(trans1);
		return trans;
	}
}
