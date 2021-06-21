package com.bank.sean.grano.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private String accountType;
	private String cardNumber;
	private float total;
	private int userId;

	public Account() {
	}

	public Account(int accountId, String accountType, String cardNumber, float total, int userId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.cardNumber = cardNumber;
		this.total = total;
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + Float.floatToIntBits(total);
		result = prime * result + userId;
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
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
