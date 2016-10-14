package com.ryry;

import java.util.Arrays;
import java.util.List;

public class WinningMove {

    private Board winningOne = new Board(new String[]{
            "x", "x", "x",
            "-", "-", "-",
            "-", "-", "-"
    });

    private Board winningTwo = new Board(new String[]{
            "x", "-", "-",
            "x", "-", "-",
            "x", "-", "-"
    });

    private Board winningThree = new Board(new String[]{
            "x", "-", "-",
            "-", "x", "-",
            "-", "-", "x"
    });

    private Board winningFour = new Board(new String[]{
            "-", "-", "x",
            "-", "-", "x",
            "-", "-", "x"
    });

    private Board winningFive = new Board(new String[]{
            "-", "-", "-",
            "x", "x", "x",
            "-", "-", "-"
    });

    private Board winningSix = new Board(new String[]{
            "-", "x", "-",
            "-", "x", "-",
            "-", "x", "-"
    });

    private Board winningSeven = new Board(new String[]{
            "-", "-", "x",
            "-", "x", "-",
            "x", "-", "-"
    });

    private Board winningEight = new Board(new String[]{
            "-", "-", "-",
            "-", "-", "-",
            "x", "x", "x"
    });



}
