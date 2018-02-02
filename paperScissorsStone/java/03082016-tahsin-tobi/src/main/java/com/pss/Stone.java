package com.pss;

public class Stone implements Tool {

    @Override
    public boolean beat(Tool anotherTool) {
        return true;
    }
}
