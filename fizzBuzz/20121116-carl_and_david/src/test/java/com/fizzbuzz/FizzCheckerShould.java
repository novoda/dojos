package com.fizzbuzz;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FizzCheckerShould {

    @Test
    public void ensure_multiple_of_3_are_checked() {

		assertThat(
				new FizzChecker().check(3), equalTo(true));
		                                      assertTrue(true);
    }
}
