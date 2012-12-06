package com.novoda.dojos.bankaccount;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;

public class StatementShould {

	private Statement statement;

	@Test
	public void haveThisFormat(){
		statement = new Statement();
		
		haveTodaysDate();
		haveABalance();
	}
	
	public void haveTodaysDate(){
		assertTrue(statement.toString().contains("Statement: 06/12/2012"));
	}
	
	public void haveABalance(){
		//assertTrue(statement.toString().contains("Balance"));
	}
	
}
