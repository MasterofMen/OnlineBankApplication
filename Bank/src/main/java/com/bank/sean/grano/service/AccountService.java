package com.bank.sean.grano.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sean.grano.dao.AccountDAO;
import com.bank.sean.grano.dto.Account;

@Service
@Transactional
public class AccountService {
	@Autowired
	AccountDAO accountD;

	// finds account by userId
	public Account findAccountByUserId(int id) {
		try {
			return accountD.findByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// finds account by accountId
	public Account findAccountByAccountId(int id) {
		try {
			return accountD.findByAccountId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// creates/update Account
	public Account saveAccount(Account account) {
		return accountD.save(account);
	}

	// deletes account by userId
	public Boolean deleteAccount(int id) {
		try {
			accountD.deleteByuserId(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
