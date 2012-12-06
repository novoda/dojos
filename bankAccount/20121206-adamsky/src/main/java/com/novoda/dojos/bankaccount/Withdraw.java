package com.novoda.dojos.bankaccount;

public class Withdraw extends Transaction {
    public Withdraw(Money withdrawal) {
        super(withdrawal);
    }

    @Override
    public Money act(Money money) {
        return money.sub(amount());
    }
}

