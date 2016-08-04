package com.pss;

import com.pss.PaperScissorsStone.Paper;
import com.pss.PaperScissorsStone.Result;
import com.pss.PaperScissorsStone.Stone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaperScissorsStoneTest {

    @Test
    public void proveTestsRun() throws Exception {
        assertEquals("Test Method failed.", 0, 0);
    }

    @Test
    public void stoneBeatsScissors() {

        PaperScissorsStone game = PaperScissorsStone.create(new Paper(), new Stone());

        assertEquals(game.play(), Result.WIN);

    }

    @Test
    public void stoneDoesLosesVsPaper() {

        PaperScissorsStone game = PaperScissorsStone.create(new Stone(), new Paper());

        assertEquals(game.play(), Result.LOSE);

    }

    @Test
    public void stoneTiesVsStone() {

        PaperScissorsStone game = PaperScissorsStone.create(new Stone(), new Stone());

        assertEquals(game.play(), Result.TIE);

    }

    @Test
    public void scissorsBeatsPaper() {

        PaperScissorsStone game = new PaperScissorsStone(new PaperScissorsStone.Scissors(), new Paper());

        assertEquals(game.play(), Result.WIN);
    }

}
