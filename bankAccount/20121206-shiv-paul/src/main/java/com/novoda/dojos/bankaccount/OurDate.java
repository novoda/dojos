package com.novoda.dojos.bankaccount;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OurDate {
	private final Date date;
	
	public OurDate() {
		date = new Date();
	}
	
	@SuppressWarnings("deprecation")
	public OurDate(int day, int month, int year) {
		date = new Date(year - 1900, month - 1, day);
	}
	
	@Override
	public String toString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
}
