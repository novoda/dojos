package com.novoda.dojos.bankaccount;

import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TransactionShould {

    Date date = new Date();
    private final Amount ten = new Amount(10);

    @Test
    public void ensureDepositEqualsDeposit(){
        Deposit d1=new Deposit(date, ten);
        Deposit d2=new Deposit(date, ten);
        assertTrue(d1.equals(d2));
    }

    @Test
    public void ensureTwoDepositsWithDifferentDatesButTheSameAmountAreNotEqual() throws InterruptedException {
        Date earlier = new Date();
        Thread.sleep(10);
        Date later = new Date();

        Deposit d1=new Deposit(earlier, ten);
        Deposit d2=new Deposit(later, ten);

        assertFalse(d1.equals(d2));
    }

    @Test
    public void ensureTwoDepositsWithSameDateButDifferentAmountsAreNotEqual() throws InterruptedException {
        Deposit d1=new Deposit(date, ten);
        Deposit d2=new Deposit(date,new Amount(20));
        assertFalse(d1.equals(d2));
    }

    @Test
    public void ensureADepositForTheSameAmountAndDateOfAWithdrawalIsNotTheSame() throws InterruptedException {
        Deposit deposit=new Deposit(date, ten);
        Withdrawal withdrawal=new Withdrawal(date, ten);
        assertFalse(deposit.equals(withdrawal));
    }


    @Test
    public void ensureAWithdrawalForTheSameAmountAndDateOfADepositIsNotTheSame() throws InterruptedException {
        Withdrawal withdrawal=new Withdrawal(date, ten);
        Deposit deposit=new Deposit(date, ten);
        assertFalse(withdrawal.equals(deposit));
    }

}
