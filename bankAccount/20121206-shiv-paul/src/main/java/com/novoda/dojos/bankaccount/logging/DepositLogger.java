package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;

import java.util.Map;

public class DepositLogger {

	private final Map<Account, Money> deposits;
	
	public DepositLogger(Map<Account, Money> backedWith) {
		this.deposits = backedWith;
	}
	
	public void log(Account account, Money money){
		deposits.put(account, money);
	}
	
}
