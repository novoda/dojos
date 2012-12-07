package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;

public class TransactionLogger implements Logger<Type, Account, Money> {
	public enum Type { DEPOSIT , WITHDRAWAL };

	private final DepositLogger depositLogger;
	
	public TransactionLogger(DepositLogger depositLogger) {
		this.depositLogger = depositLogger;
	}

	@Override
	public void log(Type type, Account account, Money money) {
		depositLogger.log(account, money);
	}
	
	private void logDeposit(Account account, Money money) {

	}

	private void logWithdrawal(Account account, Money money) {
		
	}

}
