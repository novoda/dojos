package com.novoda.dojos.bankaccount;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MoneyShould {

    @Test
    public void store_a_value(){
        assertTrue(createMoney(1).getValue() != 0);
    }

    @Test
    public void have_a_default_value() {
        assertEquals(0, new Money().getValue());
    }

    @Test
    public void be_additive() {
        Money  first= createMoney(10);
        Money against = createMoney(2);
        Money whatWeGet = first.add(against);
        assertThat(12, equalTo(whatWeGet.getValue()));
    }



    private Money createMoney(int value) {
        return new Money(value);
    }

}
