package com.novoda.dojos.bankaccount;

import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.*;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;



public class HsbcBank implements Bank {
	
	private final Logger logger;
	
	public HsbcBank() {
		this(new TransactionLogger(new DepositLogger(), new WithdrawalLogger()));
	}
	
	public HsbcBank(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void deposit(Account account, Money money) {
		account.add(money);
		logger.log(Type.DEPOSIT, account, money);
	}

	@Override
	public void withdraw(Account account, Money money) {
		account.remove(money);
		logger.log(Type.WITHDRAWAL, account, money);
		
	}

	@Override
	public void transfer(Account account1, Account account2, Money money) {
		account1.remove(money);
		account2.add(money);
	}

	@Override
	public Statement printStatementFor(Account account) {
		Statement statement = new Statement(account);

		return statement;
	}
}
