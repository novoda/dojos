package com.novoda.dojos.bankaccount;

import static org.mockito.Mockito.verify;

import com.novoda.dojos.bankaccount.Bank.Account;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BankShould {

    private Bank bank;
	@Mock private Account account;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		bank = new Bank(account);
	}
	
    @Test
    public void canMakeDeposit(){
    	Money money = new Money();
		bank.deposit(money);
    	
    	verify(account).add(money);
    }
    
    @Test
    public void canMakeWithdrawal(){
    	Money money = new Money();
    	bank.withdraw(money);
    	verify(account).remove(money);
    }
}