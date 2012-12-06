package com.novoda.dojos.bankaccount;

import com.novoda.dojos.bankaccount.BankAccount.Account;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

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
    	bankAccount.deposit(5);
    	
    	Mockito.verify(account).add(5);
    }
}