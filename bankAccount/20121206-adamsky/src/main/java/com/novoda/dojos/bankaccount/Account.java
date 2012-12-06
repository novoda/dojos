package com.novoda.dojos.bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final List<Transaction> transactions;

    public Account() {
        transactions = Collections.emptyList();
    }

    private Account(Transaction head, List<Transaction> tail) {
        transactions = new ArrayList<Transaction>(tail);
        transactions.add(head);
    }

    public Account deposit(Money deposit) {
        return action(new Deposit(deposit));
    }

    public Money balance() {
        Money tmp = new Money();
        for (Transaction t : transactions) {
            tmp = getNext(tmp, t);
        }
        return tmp;
    }

    private Money getNext(Money tmp, Transaction t) {
        if (t instanceof Deposit) {
            tmp = tmp.add(t.amount());
        } else if (t instanceof Withdraw) {
            tmp = tmp.sub(t.amount());
        }
        return tmp;
    }

    public Account withdraw(Money withdrawal) {
        return action(new Withdraw(withdrawal));
    }

    private Account action(Transaction transaction) {
        return new Account(transaction, transactions);
    }
}
