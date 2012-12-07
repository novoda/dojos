package com.novoda.dojos.bankaccount;

import com.novoda.dojos.bankaccount.domain.Money;

public interface Account {
	void add(Money money);
	void remove(Money money);
	Money getBalance();
}
