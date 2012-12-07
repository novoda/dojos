package com.novoda.dojos.bankaccount;

import static org.junit.Assert.assertEquals;

import com.novoda.dojos.bankaccount.domain.OurDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class OurDateShould {
	@Test
	public void beFormattedCorrectlyWithDefaultConstructor(){
		OurDate date = new OurDate();
		
		assertEquals(date.toString(), new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
	}
	
	@Test
	public void beFormattedCorrectlyWithSelectDateConstructor(){
		OurDate date = new OurDate(6, 12, 2012);
		
		assertEquals(date.toString(), "06/12/2012");
	}
}
