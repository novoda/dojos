package com.novoda.dojos.bankaccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final List<Money> monies;

    public Account() {
        monies = Collections.emptyList();
    }

    public Account(Money head, List<Money> tail) {
        monies = new ArrayList<Money>(tail);
        monies.add(head);
    }

    public Account deposit(Money initialDeposit) {
        return new Account(initialDeposit, monies);
    }

    public Money balance() {
        return head();
    }

    private Money head() {
        return monies.get(monies.size() - 1);
    }
}
