package com.novoda.dojos.bankaccount;


public interface Bank {

	void deposit(Account account, Money money);

	void withdraw(Account account, Money money);

	void transfer(Account account1, Account account2, Money money);

}