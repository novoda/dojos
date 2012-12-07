package com.novoda.dojos.bankaccount;

import com.novoda.dojos.bankaccount.TransactionLogger.Type;

public interface Logger {

	void log(Type type, Account account, Money money);

}