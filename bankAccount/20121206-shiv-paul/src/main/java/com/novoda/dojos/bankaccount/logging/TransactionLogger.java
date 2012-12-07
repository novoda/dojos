package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;

public class TransactionLogger implements Logger {
	public enum Type { DEPOSIT , WITHDRAWAL };
	
	@Override
	public void log(Type type, Account account, Money money) {

	}
	
	private void logDeposit(Account account, Money money) {

	}

	private void logWithdrawal(Account account, Money money) {
		
	}

}
