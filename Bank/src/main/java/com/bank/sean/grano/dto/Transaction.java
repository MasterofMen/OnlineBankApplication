package com.bank.sean.grano.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private float amount;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date transDate;
	private String type;
	private float balance;
	private String description;
	private int accountId;

	public Transaction() {
	}

	public Transaction(int transactionId, float amount, Date transDate, String type, float balance, String description,
			int accountId) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transDate = transDate;
		this.type = type;
		this.balance = balance;
		this.description = description;
		this.accountId = accountId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date date) {
		this.transDate = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result + transactionId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (accountId != other.accountId)
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
