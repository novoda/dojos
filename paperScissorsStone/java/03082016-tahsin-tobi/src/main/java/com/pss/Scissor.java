package com.pss;

public class Scissor implements Tool {

    @Override
    public boolean beat(Tool anotherTool) {
        return true;
    }
}
