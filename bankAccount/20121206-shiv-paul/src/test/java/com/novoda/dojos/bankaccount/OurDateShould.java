package com.novoda.dojos.bankaccount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OurDateShould {
	@Test
	public void beFormattedCorrectly(){
		OurDate date = new OurDate();
		
		assertEquals(date.toString(), "06/12/2012");
	}
}
