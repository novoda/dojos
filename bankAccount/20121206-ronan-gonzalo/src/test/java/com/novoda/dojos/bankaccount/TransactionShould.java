package com.novoda.dojos.bankaccount;

import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TransactionShould {


    @Test
    public void ensureDepositEqualsDeposit(){
        Date date = new Date();

        Deposit d1=new Deposit(date,new Amount(10));

        Deposit d2=new Deposit(date,new Amount(10));

        assertTrue(d1.equals(d2));

    }

    @Test
    public void ensureTwoDepositsWithDifferentDatesButTheSameAmmountAreNotEqual() throws InterruptedException {
        Date earlier = new Date();
        Thread.sleep(10);
        Date later = new Date();

        Deposit d1=new Deposit(earlier,new Amount(10));

        Deposit d2=new Deposit(later,new Amount(10));

        assertFalse(d1.equals(d2));

    }



}
