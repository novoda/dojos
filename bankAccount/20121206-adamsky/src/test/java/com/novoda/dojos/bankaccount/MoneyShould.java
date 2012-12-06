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
        int firstValue = 10;
        int againstValue = 2;
        Money  first= createMoney(firstValue);
        Money against = createMoney(againstValue);
        Money whatWeGet = first.add(against);
        assertThat(createMoney(firstValue + againstValue), equalTo(whatWeGet));
    }

    @Test
    public void be_subtractive() {
        Money  first= createMoney(5);
        Money against = createMoney(15);
        Money whatWeGet = first.sub(against);
        assertThat(createMoney(-10), equalTo(whatWeGet));
    }

    @Test
    public void be_equal_if_contains_the_same_value() {
        Money first = createMoney(5);
        Money against = createMoney(5);
        assertThat(first, equalTo(against));
    }


    private Money createMoney(int value) {
        return new Money(value);
    }

}
