package com.novoda.dojos.bankaccount;

import static org.mockito.Mockito.verify;

import com.novoda.dojos.bankaccount.BankAccount.Account;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BankAccountShould {

    private BankAccount bankAccount;
	@Mock private Account account;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		bankAccount = new BankAccount(account);
	}
	
    @Test
    public void canMakeDeposit(){
    	Money money = new Money();
		bankAccount.deposit(money);
    	
    	verify(account).add(money);
    }
}