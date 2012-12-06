package com.novoda.dojos.bankaccount;

import java.util.Date;

/**
 * Author: zero
 * Date: 12/6/12
 */
public class Deposit extends Transaction {
    public Deposit(Date date, Amount amount) {
        super(date, amount);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj!=null &&!(obj instanceof Deposit)){
            return false;
        }
        return  super.equals(obj);

    }
}
