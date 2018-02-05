package com.pss;

import com.pss.PaperScissorsStone.Paper;
import com.pss.PaperScissorsStone.Result;
import com.pss.PaperScissorsStone.Scissors;
import com.pss.PaperScissorsStone.Stone;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
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

        Result result = game.play();

        assertThat(result).isEqualTo(Result.WIN);
    }

    @Test
    public void stoneDoesLosesVsPaper() {
        PaperScissorsStone game = PaperScissorsStone.create(new Stone(), new Paper());

        Result result = game.play();

        assertThat(result).isEqualTo(Result.LOSE);
    }

    @Test
    public void stoneTiesVsStone() {
        PaperScissorsStone game = PaperScissorsStone.create(new Stone(), new Stone());

        Result result = game.play();

        assertThat(result).isEqualTo(Result.TIE);
    }

    @Test
    public void scissorsBeatPaper() {
        PaperScissorsStone game = new PaperScissorsStone(new Scissors(), new Paper());

        Result result = game.play();

        assertThat(result).isEqualTo(Result.WIN);
    }

}
