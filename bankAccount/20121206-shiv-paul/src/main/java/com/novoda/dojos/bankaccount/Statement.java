package com.novoda.dojos.bankaccount;


public class Statement {
	private final OurDate date;
	
	public Statement() {
		date = new OurDate();
	}
	
	@Override
	public String toString() {
		return "Statement: "+ date.toString();
	}
}