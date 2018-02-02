package com.pss;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PaperScissorsStoneTest {

    private PaperScissorsStone paperScissorsStone;
    private PaperScissorsStone.Scissors scissors;
    private PaperScissorsStone.Paper paper;
    private PaperScissorsStone.Stone stone;

    @Before
    public void setUp() {
        paperScissorsStone = new PaperScissorsStone();
        scissors = new PaperScissorsStone.Scissors();
        paper = new PaperScissorsStone.Paper();
        stone = new PaperScissorsStone.Stone();
    }

    @Test
    public void proveTestsRun() throws Exception {
        assertEquals("Test Method failed.", 0, 0);
    }

    @Test
    public void scissorsBeatsPaper() {

        Move result = paperScissorsStone.result(scissors, paper);

        assertThat(result).isEqualTo(scissors);
    }

    @Test
    public void paperBeatsStone() {

        Move result = paperScissorsStone.result(stone, paper);

        assertThat(result).isEqualTo(paper);
    }

    @Test
    public void stoneBeatsScissors() {

        Move result = paperScissorsStone.result(scissors, stone);

        assertThat(result).isEqualTo(stone);
    }

}
