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
	@Mock private WithdrawalLogger mockWithdrawalLogger;
	
	private Logger<Type, Account, Money> logger;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		logger = new TransactionLogger(mockDepositLogger, mockWithdrawalLogger);
	}
	
	@Test
	public void logADeposit(){
		logger.log(Type.DEPOSIT, null, null);
		
		verify(mockDepositLogger).log(null, null);
	}
	
	@Test
	public void logAWithdrawal(){
		logger.log(Type.WITHDRAWAL, null, null);
		
		verify(mockWithdrawalLogger).log(null, null);
	}
}
