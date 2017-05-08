package com.novoda.demos.virtualdiskkata;

import java.util.ArrayList;
import java.util.List;

class Directory implements Resource {

    private final String name;
    private final List<Resource> resources;

    Directory(String name) {
        this.name = name;
        this.resources = new ArrayList<>();

    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Resource resource : resources) {
            size += resource.getSize();
        }
        return size;
    }

    public int fileCount() {
        return resources.size();
    }

    public void remove(Resource resource) {
        resources.remove(resource);
    }

    public void store(Resource resource) {
        resources.add(resource);
    }

    public int mp3FileCount() {
        int mp3FileCount = 0;
        for (Resource resource : resources) {
            if (resource instanceof Directory) {
                mp3FileCount += ((Directory) resource).mp3FileCount();
            } else if (resource.name().endsWith(".mp3")) {
                mp3FileCount++;
            }
        }
        return mp3FileCount;
    }
}
