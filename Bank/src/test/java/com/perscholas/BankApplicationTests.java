package com.perscholas;

import org.junit.Before;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.sean.grano.dao.TransactionDAO;
import com.bank.sean.grano.dao.UserDAO;

@SpringBootTest
class BankApplicationTests {
	@Mock
	private UserDAO userD;
	@Mock
	private TransactionDAO transD;

	@Before
	public void setUp() {
	}

}
