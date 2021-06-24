package com.perscholas.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bank.sean.grano.dao.AccountDAO;
import com.bank.sean.grano.dto.Account;
import com.bank.sean.grano.service.AccountService;

class AccountDAOTest {
	@Mock
	private AccountDAO accountD;
	@InjectMocks
	private AccountService accountS;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		when(accountD.findByAccountId(1)).thenReturn(new Account(1, "Checking", "123456789", 5000.0f, 1));
		when(accountD.findByUserId(1)).thenReturn(new Account(1, "Checking", "123456789", 5000.0f, 1));
		when(accountD.save(mockAccount())).thenReturn(new Account(1, "Checking", "123456789", 5000.0f, 1));
	}

	@Test
	void testFindByUserId() {
		Account account = accountS.findAccountByUserId(1);
		Account account2 = mockAccount();
		account2.setAccountId(1);
		assertEquals(account, account2);
	}

	@Test
	void testFindByAccountId() {
		Account account = accountS.findAccountByAccountId(1);
		Account account2 = mockAccount();
		account2.setAccountId(1);
		assertEquals(account, account2);
	}

	@Test
	void testSaveAccount() {
		Account account = accountS.saveAccount(mockAccount());
		Account account2 = mockAccount();
		account2.setAccountId(1);
		assertEquals(account, account2);
	}

	@Test
	void deleteAccount() {
		assertTrue(accountS.deleteAccount(1));
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
