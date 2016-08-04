package com.pss;

public class PaperScissorsStone {

    boolean play(Tool tool, Tool anotherTool) {
        return tool.beat(anotherTool);
    }

}
