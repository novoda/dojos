package com.novoda.dojos.bankaccount;

import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.*;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;

import java.util.HashMap;



public class HsbcBank implements Bank {
	
	private final Logger<Type, Account, Money> logger;
	
	public HsbcBank() {
		this(new TransactionLogger(new DepositLogger(new HashMap<Account, Money>()), new WithdrawalLogger(new HashMap<Account, Money>())));
	}
	
	public HsbcBank(Logger<Type, Account, Money> logger) {
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
