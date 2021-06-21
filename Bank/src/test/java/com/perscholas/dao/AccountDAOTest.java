package com.perscholas.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.sean.grano.dao.AccountDAO;
import com.bank.sean.grano.dto.Account;

class AccountDAOTest {

	private AccountDAO accountD;

	@BeforeEach
	void setUp() {
		accountD = mock(AccountDAO.class);
		when(accountD.findByAccountId(1)).thenReturn(new Account(1, "Checking", "123456789", 5000.0f, 1));
		when(accountD.findByUserId(1)).thenReturn(new Account(1, "Checking", "123456789", 5000.0f, 1));
		when(accountD.save(mockAccount())).thenReturn(new Account(1, "Checking", "123456789", 5000.0f, 1));
	}

	@Test
	void testFindByUserId() {
		Account account = accountD.findByUserId(1);
		Account account2 = mockAccount();
		account2.setAccountId(1);
		assertEquals(account, account2);
	}

	@Test
	void testFindByAccountId() {
		Account account = accountD.findByAccountId(1);
		Account account2 = mockAccount();
		account2.setAccountId(1);
		assertEquals(account, account2);
	}

	@Test
	void testSaveAccount() {
		Account account = accountD.save(mockAccount());
		Account account2 = mockAccount();
		account2.setAccountId(1);
		assertEquals(account, account2);
	}

	Account mockAccount() {
		Account account = new Account();
		account.setAccountType("Checking");
		account.setCardNumber("123456789");
		account.setTotal(5000.0f);
		account.setUserId(1);
		return account;
	}

}
