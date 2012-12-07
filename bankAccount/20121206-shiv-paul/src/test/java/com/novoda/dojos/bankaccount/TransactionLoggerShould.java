package com.novoda.dojos.bankaccount;

import static org.mockito.Mockito.verify;

import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.*;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TransactionLoggerShould {

	@Mock private DepositLogger mockDepositLogger;
	private Logger<Type, Account, Money> logger;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		logger = new TransactionLogger(mockDepositLogger);
	}
	
	@Test
	public void logADeposit(){
		Money money = new Money();
		
		logger.log(Type.DEPOSIT, account, money);
		
		verify(mockDepositLogger).log(account, money);
	}
	
	private final Account account = new Account() {
		@Override
		public void remove(Money money) {
		}
		
		@Override
		public Money getBalance() {
			return null;
		}
		
		@Override
		public void add(Money money) {
		}
	};
	
}
