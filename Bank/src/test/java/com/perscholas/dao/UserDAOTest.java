package com.perscholas.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.sean.grano.dao.UserDAO;
import com.bank.sean.grano.dto.User;

class UserDAOTest {

	UserDAO userD;
	List<String> usernames = new ArrayList<>();

	@BeforeEach
	void setUp() {
		usernames.add("Bob1");
		usernames.add("Bob2");
		usernames.add("Bob3");
		userD = mock(UserDAO.class);
		when(userD.findByUsername("bb123"))
				.thenReturn(new User(1, "Bob", "Bobby", "bob@gmail.com", "123456789", "bb123", "1!Bob"));
		when(userD.findById(1)).thenReturn(new User(1, "Bob", "Bobby", "bob@gmail.com", "123456789", "bb123", "1!Bob"));
		when(userD.save(mockUser()))
				.thenReturn(new User(1, "Bob", "Bobby", "bob@gmail.com", "123456789", "bb123", "1!Bob"));
		when(userD.findAllUsernames()).thenReturn(usernames);
	}

	@Test
	void testFindByUsername() {
		User user = userD.findByUsername("bb123");
		User user2 = mockUser();
		user2.setId(1);
		assertEquals(user, user2);
	}

	@Test
	void testFindByIdInt() {
		User user = userD.findById(1);
		User user2 = mockUser();
		user2.setId(1);
		assertEquals(user, user2);
	}

	@Test
	void testCreateUser() {
		User user = userD.save(mockUser());
		User user2 = mockUser();
		user2.setId(1);
		assertEquals(user, user2);
	}

	@Test
	void getAllUsernames() {
		assertEquals(usernames, userD.findAllUsernames());
	}

	User mockUser() {
		User user = new User();
		user.setFirstName("Bob");
		user.setLastName("Bobby");
		user.setEmail("bob@gmail.com");
		user.setSso("123456789");
		user.setUsername("bb123");
		user.setPassword("1!Bob");
		return user;
	}

}
