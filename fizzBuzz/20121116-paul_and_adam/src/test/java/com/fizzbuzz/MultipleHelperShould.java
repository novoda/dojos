package com.fizzbuzz;

import static com.fizzbuzz.MultipleHelper.isMultipleOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MultipleHelperShould{

    @Test
    public void returnTrueIfNumberIs9andMultipleIs3() {
    	assertTrue(isMultipleOf(3, 9));
    }
    
    @Test
    public void returnTrueIfNumberIs10andMultipleIs5() {
    	assertTrue(isMultipleOf(5, 10));
    }
    
    @Test
    public void returnFalseIfNumberIs9andMultipleIs5() {
    	assertFalse(isMultipleOf(5, 9));
    }
    
    @Test
    public void returnFalseIfNumberIs10andMultipleIs3() {
    	assertFalse(isMultipleOf(3, 10));
    }

    @Test
    public void returnTrueIfNumberIs30andMultipleIs3and5() {
    	assertTrue(isMultipleOf(3, 30) && isMultipleOf(5, 30));
    }
    
}
