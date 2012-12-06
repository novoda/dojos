package com.novoda.dojos.bankaccount;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.stub;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StatementShould {

	private Statement statement;
	@Mock private Account account;
	private final Money balance = new Money();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		stub(account.getBalance()).toReturn(balance);

		statement = new Statement(account);
	}

	@Test
	public void haveThisFormat(){
		
		
		haveTodaysDate();
		haveABalance();
	}
	
	public void haveTodaysDate(){
		assertTrue(statement.toString().contains("Statement: 06/12/2012"));
	}
	
	public void haveABalance(){
		assertTrue(statement.toString().contains(balance.toString()));
	}
	
}
