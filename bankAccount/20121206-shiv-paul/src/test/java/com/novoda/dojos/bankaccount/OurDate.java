package com.novoda.dojos.bankaccount;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OurDate {
	private final Date date;
	
	public OurDate() {
		date = new Date();
	}
	
	@Override
	public String toString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
}
