package com.novoda.dojos.bankaccount;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class AmountShould {

    @Test
    public void confirmTwoAmountsOfTheSameValueAreEqual(){

       Amount a =new Amount(1);
       Amount b =new Amount(1);

       assertTrue(a.equals(b));

    }

    public void confirmTwoDiffrentAmountsAreNotEqual(){

        Amount a =new Amount(1);
        Amount b =new Amount(2);

        assertFalse(a.equals(b));


    }

}
