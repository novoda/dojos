package com.novoda.dojos.bankaccount;


public class BankAccount {

    private Money balance;

    public BankAccount(Money money) {
        this.balance = money;
    }

    public void deposit(Money amount) {
        this.balance.add(amount);
    }

    public void withdraw(Money amount) {
        this.balance.remove(amount);
    }
}