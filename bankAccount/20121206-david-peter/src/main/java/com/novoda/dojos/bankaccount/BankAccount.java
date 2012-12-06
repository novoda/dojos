package com.novoda.dojos.bankaccount;


public class BankAccount {


    public int balance;

    public BankAccount(int amount) {
        this.balance += amount;
    }

    public boolean isItTrue() {
        return true;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}