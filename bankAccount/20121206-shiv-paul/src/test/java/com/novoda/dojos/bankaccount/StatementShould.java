package com.novoda.dojos.bankaccount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatementShould {

	@Test
	public void haveTodaysDate(){
		Statement statement = new Statement();
		
		assertEquals(statement.toString(), "Statement: 06/12/2012");
	}
	
}
