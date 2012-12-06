package com.novoda.dojos.bankaccount;




public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        Amount other = (Amount) obj;
        return other.value == value;
    }
}