package com.bowling;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KataSetupTest {

    @Test
    public void testIsSetup() throws Exception {
        KataSetup kataSetup = new KataSetup();

        boolean setup = kataSetup.isSetup();

        assertTrue(setup);
    }
}
