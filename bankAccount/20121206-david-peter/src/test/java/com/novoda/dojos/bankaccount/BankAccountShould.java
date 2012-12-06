package com.novoda.dojos.bankaccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BankAccountShould {

    private BankAccount bankAccount;
    private final int DEPOSIT = 200;

    @Before
    public void setupAccount(){
        bankAccount = new BankAccount(DEPOSIT);
    }

    @After
    public void cleanUp(){
        bankAccount = null;
    }

    @Test
    public void account_should_accept_the_first_deposit(){
        int preDepositBalance = bankAccount.balance;
        bankAccount.deposit(DEPOSIT);
        assertEquals(bankAccount.balance, preDepositBalance+DEPOSIT);
    }

    @Test
    public void account_should_accept_deposits(){
        int preDepositeBalance = bankAccount.balance;
        bankAccount.deposit(200);
        assertEquals(bankAccount.balance, preDepositeBalance + DEPOSIT);

        preDepositeBalance = bankAccount.balance;
        bankAccount.deposit(200);
        assertEquals(bankAccount.balance, preDepositeBalance+DEPOSIT);
    }



}
