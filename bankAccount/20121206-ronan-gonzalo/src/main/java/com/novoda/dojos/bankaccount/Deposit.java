package com.novoda.dojos.bankaccount;

import java.util.Date;

public class Deposit extends Transaction {
    public Deposit(Date date, Amount amount) {
        super(date, amount);
    }
}
