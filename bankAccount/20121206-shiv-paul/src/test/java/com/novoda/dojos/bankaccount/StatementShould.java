package com.novoda.dojos.bankaccount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatementShould {

	@Test
	public void haveTodaysDate(){
		Statement statement = new Statement();
		Statement expectedStatement = new Statement();
		assertEquals(expectedStatement, statement);
	}
	
}
