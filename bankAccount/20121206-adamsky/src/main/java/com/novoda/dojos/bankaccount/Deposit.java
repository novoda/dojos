package com.novoda.dojos.bankaccount;

public class Deposit extends Transaction {
    public Deposit(Money withdrawal) {
        super(withdrawal);
    }

    @Override
    public Money act(Money money) {
       return money.add(amount());
    }
}
