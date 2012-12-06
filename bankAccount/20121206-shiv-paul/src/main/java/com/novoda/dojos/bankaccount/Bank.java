package com.novoda.dojos.bankaccount;



public class Bank {
	public interface Account {
    	void add(Money money);
    	void remove(Money money);
    }
	
	Account account;
	
	public Bank(Account account) {
		this.account = account;
	}
	
	public void deposit(Money money) {
		account.add(money);
	}

	public void withdraw(Money money) {
		account.remove(money);
		
	}

	public void transfer(Account account1, Account account2, Money money) {
		account1.remove(money);
		account2.add(money);
	}
}
