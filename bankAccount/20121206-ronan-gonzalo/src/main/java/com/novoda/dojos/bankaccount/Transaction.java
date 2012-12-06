package com.novoda.dojos.bankaccount;


import java.util.Date;

public abstract class Transaction {

    protected final Date date;

    @Override
    public boolean equals(Object obj) {
        Transaction t=(Transaction)obj;
        return t.date.equals(this.date) && t.amount.equals(this.amount);

    }

    protected final Amount amount;

    public Transaction(Date date, Amount amount) {
        this.date = date;
        this.amount = amount;
    }



}
