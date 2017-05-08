package com.novoda.demos.virtualdiskkata;


public class Storage {

    private final Directory rootDirectory;

    public Storage() {
        rootDirectory = new Directory("/");
    }

    public Directory rootDirectory() {
        return rootDirectory;
    }

    public int totalSize() {
        return rootDirectory.getSize();
    }

    public int mp3FileCount() {
        return rootDirectory.mp3FileCount();
    }
}
