package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.OurDate;


public class Statement {
	private final OurDate date;
	private final Account account;
	
	public Statement(Account account) {
		date = new OurDate();
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Statement: "+ date.toString() + " " + account.getBalance();
	}
}