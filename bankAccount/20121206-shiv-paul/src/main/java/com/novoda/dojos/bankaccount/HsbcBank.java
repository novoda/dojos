package com.novoda.dojos.bankaccount;



public class HsbcBank implements Bank {
	
	@Override
	public void deposit(Account account, Money money) {
		account.add(money);
	}

	@Override
	public void withdraw(Account account, Money money) {
		account.remove(money);
		
	}

	@Override
	public void transfer(Account account1, Account account2, Money money) {
		account1.remove(money);
		account2.add(money);
	}

	@Override
	public Statement printStatementFor(Account account) {
		Statement statement = new Statement();

		return statement;
	}
}
