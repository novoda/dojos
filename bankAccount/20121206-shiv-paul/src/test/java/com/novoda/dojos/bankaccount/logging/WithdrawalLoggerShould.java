package com.novoda.dojos.bankaccount.logging;

import static org.mockito.Mockito.verify;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WithdrawalLoggerShould {
	private WithdrawalLogger logger;

	@Mock
	Map<Account, Money> map;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		logger = new WithdrawalLogger(map);
	}

	@Test
	public void log() {
		Money money = new Money();
		logger.log(account, money);

		verify(map).put(account, money);
	}

	Account account = new Account() {
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
