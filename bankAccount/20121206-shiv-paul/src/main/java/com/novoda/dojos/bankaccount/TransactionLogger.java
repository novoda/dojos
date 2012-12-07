package com.novoda.dojos.bankaccount;

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
