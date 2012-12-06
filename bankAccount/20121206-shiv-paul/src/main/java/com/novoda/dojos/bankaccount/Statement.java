package com.novoda.dojos.bankaccount;


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