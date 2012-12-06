package com.novoda.dojos.bankaccount;

public class Money {

    private static final int WORTHLESS = 0;
    private final int value;

    public Money() {
        this(WORTHLESS);
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

    public Money sub(Money other) {
        return new Money(getValue() - other.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (value != money.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}

