package com.novoda.dojos.bankaccount;

public abstract class Transaction {

    private final Money withdrawal;
    private final long when;

    public Transaction(Money withdrawal) {
        this.withdrawal = withdrawal;
        this.when = System.currentTimeMillis();
    }

    public long when() {
        return when;
    }

    public Money amount() {
        return withdrawal;
    }

    public abstract Money act(Money money);

}
