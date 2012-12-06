package com.novoda.dojos.bankaccount;

public class Money {

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money add(Money money){
        return new Money(this.amount + money.amount);
    }

    public Money remove(Money money) {
        return new Money(this.amount - money.amount);
    }
}
