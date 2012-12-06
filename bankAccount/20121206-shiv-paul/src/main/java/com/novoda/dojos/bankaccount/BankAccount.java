package com.novoda.dojos.bankaccount;


public class BankAccount {
	public interface Account {
    	void add(Money money);
    	void remove(Money money);
    }
	
	Account account;
	
	public BankAccount(Account account) {
		this.account = account;
	}
	
	public void deposit(Money money) {
		account.add(money);
	}

	public void withdraw(Money money) {
		account.remove(money);
		
	}
}
