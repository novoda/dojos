package com.novoda.demos.virtualdiskkata;

public class File implements Resource {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
