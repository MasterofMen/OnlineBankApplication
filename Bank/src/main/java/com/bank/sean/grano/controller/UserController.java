package com.bank.sean.grano.controller;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.sean.grano.dto.Account;
import com.bank.sean.grano.dto.Transaction;
import com.bank.sean.grano.dto.User;
import com.bank.sean.grano.service.AccountService;
import com.bank.sean.grano.service.TransactionService;
import com.bank.sean.grano.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userS;
	@Autowired
	AccountService accountS;
	@Autowired
	TransactionService transS;

	// checks to see if the login credentials are valid
	@GetMapping("/valid")
	public ModelAndView login(@RequestParam String username, @RequestParam String password) {
		if (userS.logIn(username, password)) {
			ModelAndView mav = new ModelAndView("ViewAccount");
			User user = userS.findUserbyUsername(username);
			Account account = accountS.findAccountByUserId(user.getId());
			float trans = transS.totalTransactions(account.getAccountId());

			mav.addObject("tran", trans);
			mav.addObject("account", account);
			mav.addObject("user", user);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("index");
			mav.addObject("valid", "Invalid username or password");
			return mav;
		}
	}

	// called when pressing the deposit or withdrawal button on the transaction page
	@GetMapping("transaction/trans/{accountId}")
	public ModelAndView transaction(@PathVariable int accountId, @RequestParam String amount,
			@RequestParam String description, @RequestParam String type, @RequestParam(required = false) String deposit,
			@RequestParam(required = false) String withdrawal) {
		Account account = accountS.findAccountByAccountId(accountId);
		User user = userS.findByUserId(account.getUserId());

		Transaction transaction = new Transaction();
		Date date = new Date();

		transaction.setDescription(description);
		transaction.setAccountId(accountId);
		transaction.setType(type);
		transaction.setTransDate(date);

		if (withdrawal == null) {
			System.out.println("withdrawal called");
			transaction.setAmount(Float.parseFloat(amount));
			transaction.setBalance(account.getTotal() + transaction.getAmount());
			transS.addTransaction(transaction);
			// Thread.sleep(1000);
			account.setTotal(transaction.getBalance());
			accountS.saveAccount(account);

		} else {
			System.out.println("deposit called");
			transaction.setAmount(Float.parseFloat(amount) * -1);
			transaction.setBalance(account.getTotal() + transaction.getAmount());
			transS.addTransaction(transaction);

			account.setTotal(transaction.getBalance());
			accountS.saveAccount(account);
		}
		float trans = transS.totalTransactions(accountId);
		ModelAndView mav = new ModelAndView("ViewAccount");
		mav.addObject("account", account);
		mav.addObject("user", user);
		mav.addObject("tran", trans);
		return mav;
	}

	// called when creating an account
	@PostMapping("/create")
	public ModelAndView createAccount(@RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String email, @RequestParam String type, @RequestParam String cardNumber,
			@RequestParam String SSN, @RequestParam String username, @RequestParam String password) {
		// checks to see if the username already exists
		boolean exist = false;
		for (String i : userS.allUsernames()) {
			if (i.equals(username)) {
				exist = true;
			}
		}
		// if username doesn't exist, create a new user
		if (!exist) {
			ModelAndView mav = new ModelAndView("ViewAccount");

			User user = new User();
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setEmail(email);
			user.setSso(SSN);
			user.setUsername(username);
			user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			user = userS.createUser(user);

			Account account = new Account();
			account.setAccountType(type);
			account.setCardNumber(cardNumber);
			account.setUserId(user.getId());
			account.setTotal(0);
			account = accountS.saveAccount(account);

			float trans = transS.totalTransactions(account.getAccountId());

			mav.addObject("user", user);
			mav.addObject("account", account);
			mav.addObject("tran", trans);

			return mav;
		} else {
			ModelAndView mav = new ModelAndView("CreateAccount");
			mav.addObject("exists", "This username already exists");
			return mav;
		}
	}

	// updates user info from profile page
	@PostMapping("/profile/change/{id}")
	public ModelAndView changeUserInfo(@ModelAttribute User user, @PathVariable int id) {
		User origUser = userS.findByUserId(id);

		if (user.getFirstName() != null && !user.getFirstName().equals("")) {
			String[] arr = user.getFirstName().split(" ");
			origUser.setFirstName(arr[0]);
			origUser.setLastName(arr[1]);
		} else if (user.getEmail() != null && !user.getEmail().equals("")) {
			origUser.setEmail(user.getEmail());
		} else if (user.getUsername() != null && !user.getUsername().equals("")) {
			origUser.setUsername(user.getUsername());
		} else if (user.getPassword() != null && !user.getPassword().equals("")) {
			origUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		}
		userS.createUser(origUser);
		ModelAndView mav = new ModelAndView("ViewAccount");
		Account account = accountS.findAccountByUserId(origUser.getId());
		Float trans = transS.totalTransactions(account.getAccountId());

		mav.addObject("user", origUser);
		mav.addObject("account", account);
		mav.addObject("tran", trans);
		return mav;
	}
}
