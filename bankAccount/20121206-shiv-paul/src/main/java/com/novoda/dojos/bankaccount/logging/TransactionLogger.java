package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;

public class TransactionLogger implements Logger<Type, Account, Money> {
	public enum Type { DEPOSIT , WITHDRAWAL };

	private final DepositLogger depositLogger;
	private final WithdrawalLogger withdrawalLogger;
	
	public TransactionLogger(DepositLogger depositLogger, WithdrawalLogger withdrawalLogger) {
		this.depositLogger = depositLogger;
		this.withdrawalLogger = withdrawalLogger;
	}

	@Override
	public void log(Type type, Account account, Money money) {
		if(type == Type.DEPOSIT){
			depositLogger.log(account, money);
			return;
		}
		withdrawalLogger.log(account, money);
	}
}