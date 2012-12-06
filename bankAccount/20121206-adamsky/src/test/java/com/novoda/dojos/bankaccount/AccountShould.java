package com.novoda.dojos.bankaccount;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountShould {


    @Test
    public void deposit_money() {
        Account account = new Account();
        Money initialDeposit = new Money(5);
        Account a = account.deposit(initialDeposit);
        assertThat(a.balance(), equalTo(initialDeposit));
    }

    @Test
    public void withdraw_money() {
        Account account = new Account();
        Money initialWithdraw = new Money(5);
        Account a = account.deposit(initialWithdraw);
        assertThat(a.balance(), equalTo(initialWithdraw));
    }

}
