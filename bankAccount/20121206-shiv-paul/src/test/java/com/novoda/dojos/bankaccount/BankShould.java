package com.novoda.dojos.bankaccount;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import com.novoda.dojos.bankaccount.domain.Money;
import com.novoda.dojos.bankaccount.logging.Statement;
import com.novoda.dojos.bankaccount.logging.TransactionLogger;
import com.novoda.dojos.bankaccount.logging.TransactionLogger.Type;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BankShould {

    private Bank bank;
	@Mock private Account account;
	@Mock private Account account2;
	@Mock private TransactionLogger logger;
	private Money money;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		money = new Money();
		bank = new HsbcBank();
	}
	
    @Test
    public void canMakeDeposit(){
		bank.deposit(account, money);
    	
    	verify(account).add(money);
    }
    
    @Test
    public void canMakeWithdrawal(){
    	bank.withdraw(account, money);
    	
    	verify(account).remove(money);
    }
    
    @Test
    public void canMakeATransfer(){
		bank.transfer(account, account2, money);
    	
		verify(account).remove(money);
		verify(account2).add(money);
    }
    
    @Test
    public void printStatement(){
    	Statement statement = bank.printStatementFor(account);
    	
    	assertNotNull(statement);
    }
    
    @Test
    public void logDeposits(){
    	Bank bank = new HsbcBank(logger);
    	
    	bank.deposit(account, money);
    	
    	verify(logger).log(Type.DEPOSIT, account, money);
    }
    
    @Test
    public void logWithdrawals(){
    	Bank bank = new HsbcBank(logger);
    	
    	bank.withdraw(account, money);
    	
    	verify(logger).log(Type.WITHDRAWAL, account, money);
    }
}