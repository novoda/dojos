package com.pss;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaperScissorsStoneTest {

    @Test
    public void proveTestsRun() throws Exception {
        assertEquals("Test Method failed.", 0, 0);
    }

    @Test
    public void rockBeatsScissors() {
        Item rock = Factory.create(true);
        Item scissors = Factory.create(false);


        assertEquals(true, rock.beats(scissors));
        assertEquals(false, scissors.beats(rock));
    }

}
