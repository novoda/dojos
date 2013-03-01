package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;

import java.util.Map;

public class WithdrawalLogger {

	private final Map<Account, Money> withdrawals;

	public WithdrawalLogger(Map<Account, Money> backedWith) {
		this.withdrawals = backedWith;
	}

	public void log(Account account, Money money) {
		withdrawals.put(account, money);
	}

}
