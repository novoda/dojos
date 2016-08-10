package com.pss;

interface Visitor {
    Move visit(PaperScissorsStone.Paper paper);
    Move visit(PaperScissorsStone.Scissors scissors);
    Move visit(PaperScissorsStone.Stone stone);
}
