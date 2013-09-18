package com.bowling;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BowlingGameFactoryTest {

    @Test
    public void testIsSetup() throws Exception {
        KataSetup kataSetup = new KataSetup();

        boolean setup = kataSetup.isSetup();

        assertThat(setup).isTrue();
    }
}
