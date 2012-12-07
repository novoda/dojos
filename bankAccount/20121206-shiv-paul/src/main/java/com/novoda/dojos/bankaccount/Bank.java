package com.novoda.dojos.bankaccount;

import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.Statement;


public interface Bank {

	void deposit(Account account, Money money);

	void withdraw(Account account, Money money);

	void transfer(Account account1, Account account2, Money money);

	Statement printStatementFor(Account account);

}