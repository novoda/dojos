package com.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FizzCheckerShould {

    @Test
    public void ensure_multiple_of_3_are_checked() {

		assertThat(	new FizzChecker().check(3), equalTo(true));

    }

	@Test
	public void ensure_2_is_false() {
		assertThat(new FizzChecker().check(2), equalTo(false));
	}
}
