package com.bank.sean.grano.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sean.grano.dao.UserDAO;
import com.bank.sean.grano.dto.User;
import com.bank.sean.grano.exception.CustomException;

@Service
@Transactional
public class UserService {
	@Autowired
	UserDAO userDao;

	// checks for valid login credentials
	public Boolean logIn(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user == null) {
			return false;
		} else if (BCrypt.checkpw(password, user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	// find user by username with custom exception
	public User findUserbyUsername(String username) {
		try {
			return userDao.findByUsername(username);
		} catch (Exception e) {
			throw new CustomException("No username found!", e);
		}
	}

	// find user by id
	public User findByUserId(int id) {
		try {
			return userDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// create/update user
	public User createUser(User user) {
		return userDao.save(user);
	}

	// gets a list of all the usernames in the database
	public List<String> allUsernames() {
		return userDao.findAllUsernames();
	}

	// deletes a user
	public Boolean deleteUser(int id) {
		try {
			userDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
