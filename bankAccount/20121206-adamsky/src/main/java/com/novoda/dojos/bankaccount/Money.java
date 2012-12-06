package com.novoda.dojos.bankaccount;

public class Money {

    private final int value;

    public Money() {
        this(0);
    }

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Money add(Money other) {
        return new Money(other.getValue() + getValue());
    }
}
