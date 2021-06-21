package com.bank.sean.grano.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.bank.sean.grano.dto.Account;
import com.bank.sean.grano.dto.Transaction;
import com.bank.sean.grano.dto.User;
import com.bank.sean.grano.service.AccountService;
import com.bank.sean.grano.service.TransactionService;
import com.bank.sean.grano.service.UserService;

@Controller
public class ViewController {
	@Autowired
	UserService userS;
	@Autowired
	AccountService accountS;
	@Autowired
	TransactionService transS;

	// returns the login page
	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	// returns the create account page
	@GetMapping("/CreateAccount")
	public ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView("CreateAccount");
		return mav;
	}

	// returns the ViewAccount page with a username path variable
	@GetMapping("/ViewAccount/{username}")
	public ModelAndView viewAccount(@PathVariable String username) {
		ModelAndView mav = new ModelAndView("ViewAccount");
		User user = userS.findUserbyUsername(username);
		Account account = accountS.findAccountByUserId(user.getId());
		float trans = transS.totalTransactions(account.getAccountId());

		mav.addObject("account", account);
		mav.addObject("user", user);
		mav.addObject("tran", trans);
		return mav;
	}

	// returns the profile page with a username path variable
	@GetMapping("/profile/{username}")
	public ModelAndView viewProfile(@PathVariable String username) {
		ModelAndView mav = new ModelAndView("profile");
		User user = userS.findUserbyUsername(username);

		mav.addObject("User", user);
		return mav;
	}

	// returns the past transactions page with a path variable
	@GetMapping("/pastTrans/{accountId}")
	public ModelAndView pastTrans(@PathVariable int accountId) {
		ModelAndView mav = new ModelAndView("pastTrans");
		List<Transaction> trans = transS.findAllTransactionByAccountid(accountId);
		Account account = accountS.findAccountByAccountId(accountId);
		User user = userS.findByUserId(account.getUserId());
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

		mav.addObject("format", format);
		mav.addObject("user", user);
		mav.addObject("trans", trans);
		return mav;
	}

	@GetMapping("/transaction/{accountId}")
	public ModelAndView transaction(@PathVariable int accountId) {
		ModelAndView mav = new ModelAndView("transaction");
		Account account = accountS.findAccountByAccountId(accountId);
		User user = userS.findByUserId(account.getUserId());

		mav.addObject("account", account);
		mav.addObject("user", user);
		return mav;
	}
}
