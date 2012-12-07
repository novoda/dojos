package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;

public interface Logger {

	void log(Type type, Account account, Money money);

}