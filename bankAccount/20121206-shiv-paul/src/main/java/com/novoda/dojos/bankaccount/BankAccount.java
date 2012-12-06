package com.novoda.dojos.bankaccount;


public class BankAccount {
	public interface Account {
    	void add(int amount);
    }
	
	Account account;
	
	public BankAccount(Account account) {
		this.account = account;
	}
	
	public void deposit(int deposit) {
		account.add(deposit);
	}
}
