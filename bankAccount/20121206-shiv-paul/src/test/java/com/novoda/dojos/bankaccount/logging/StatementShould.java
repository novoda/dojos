package com.novoda.dojos.bankaccount.logging;

import com.novoda.dojos.bankaccount.Account;
import com.novoda.dojos.bankaccount.domain.Money;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class StatementShould {

	private Statement statement;
	@Mock private Account account;
	private final Money balance = new Money();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		when(account.getBalance()).thenReturn(balance);

		statement = new Statement(account);
	}

	@Test
	public void haveThisFormat(){
		haveTodaysDate();
		haveABalance();
	}
	
	public void haveTodaysDate(){
		String stmt = statement.toString();
		assertTrue("Statement was: "+ stmt, stmt.contains("Statement: "+ new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
	}
	
	public void haveABalance(){
		String stmt = statement.toString();
		assertTrue(stmt.contains(balance.toString()));
	}
	
}
