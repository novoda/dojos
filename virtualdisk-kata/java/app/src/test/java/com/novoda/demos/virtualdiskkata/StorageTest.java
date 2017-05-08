package com.novoda.demos.virtualdiskkata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StorageTest {

    @Test
    public void rootDirectoryHasDefaultName() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();

        assertEquals("/", rootDirectory.name());
    }

}
