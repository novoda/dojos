package com.novoda.dojos.bankaccount;

import java.util.Date;

public class Withdrawal extends Transaction{
    public Withdrawal(Date date, Amount amount) {
        super(date, amount);
    }
}
