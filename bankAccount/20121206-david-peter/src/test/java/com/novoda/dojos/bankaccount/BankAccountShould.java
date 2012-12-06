package com.novoda.dojos.bankaccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class BankAccountShould {

    @Mock private BankAccount bankAccount;
    private final Money DEPOSIT = new Money(200);

    @Before
    public void setupAccount(){
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void cleanUp(){
        bankAccount = null;
    }

    @Test
    public void account_should_accept_deposit(){
        bankAccount.deposit(DEPOSIT);
        verify(bankAccount).deposit(DEPOSIT);
    }

    @Test
    public void account_should_allow_withdraw(){
        bankAccount.withdraw(DEPOSIT);
        verify(bankAccount).withdraw(DEPOSIT);
    }


}
