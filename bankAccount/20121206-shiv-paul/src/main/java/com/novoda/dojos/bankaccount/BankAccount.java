package com.novoda.dojos.bankaccount;


public class BankAccount {
	public interface Account {
    	void add(Money money);
    }
	
	Account account;
	
	public BankAccount(Account account) {
		this.account = account;
	}
	
	public void deposit(Money money) {
		account.add(money);
	}
}
