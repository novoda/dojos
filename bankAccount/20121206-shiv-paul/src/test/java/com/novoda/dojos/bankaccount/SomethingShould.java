package com.novoda.dojos.bankaccount;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class SomethingShould {

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
    
    public interface Account {
    	void add(int amount);
    }
    
    public class BankAccount  {

    	Account account;
    	
    	public BankAccount(Account account) {
    		this.account = account;
    	}
    	
		public void deposit(int deposit) {
			account.add(deposit);
		}
    	
    }
    
}
