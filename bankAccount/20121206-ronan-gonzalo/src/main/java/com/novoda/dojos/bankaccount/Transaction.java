package com.novoda.dojos.bankaccount;


import java.util.Date;

public abstract class Transaction {

    private final Date date;
    private final Amount amount;

    public Transaction(Date date, Amount amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && !(obj.getClass().equals(this.getClass()))) {
            return false;
        }

        Transaction t = (Transaction) obj;
        return t.date.equals(this.date) && t.amount.equals(this.amount);
    }

}
