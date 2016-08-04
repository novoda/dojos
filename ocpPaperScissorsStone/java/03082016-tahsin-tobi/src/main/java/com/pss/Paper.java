package com.pss;

public class Paper implements Tool {
    @Override
    public boolean beat(Tool anotherTool) {
        return true;
    }
}
