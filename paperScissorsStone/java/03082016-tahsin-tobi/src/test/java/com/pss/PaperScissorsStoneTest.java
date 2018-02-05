package com.pss;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaperScissorsStoneTest {

    PaperScissorsStone game = new PaperScissorsStone();

    @Test
    public void stoneShouldBeatScissor() throws Exception {
        Stone stone = new Stone();
        Scissor scissor = new Scissor();

        boolean result = game.play(stone, scissor);

        assertEquals(true, result);
    }

    @Test
    public void scissorsBeatPaper() throws Exception {
        Scissor scissor = new Scissor();
        Paper paper = new Paper();

        boolean result = game.play(scissor, paper);

        assertEquals(true, result);
    }

    @Test
    public void paperBeatsStone() throws Exception {
        Paper paper = new Paper();
        Stone stone = new Stone();

        boolean result = game.play(paper, stone);
        assertEquals(true, result);
    }

}
