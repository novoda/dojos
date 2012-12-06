package com.novoda.dojos.bankaccount;

public interface Account {
	void add(Money money);
	void remove(Money money);
	Money getBalance();
}
