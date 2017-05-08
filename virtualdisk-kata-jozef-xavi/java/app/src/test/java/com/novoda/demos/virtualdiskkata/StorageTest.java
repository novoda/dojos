package com.novoda.demos.virtualdiskkata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class StorageTest {

    @Test
    public void rootDirectoryHasDefaultName() {
        Storage storage = new Storage();

        Resource rootDirectory = storage.rootDirectory();

        assertEquals("/", rootDirectory.name());
    }

    @Test
    public void directoryCanStoreFile() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        rootDirectory.store(new File("foo.txt", 0));

        assertEquals(1, rootDirectory.fileCount());
    }

    @Test
    public void directoryCanRemoveFile() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        File file = new File("foo.txt", 0);
        rootDirectory.store(file);
        rootDirectory.remove(file);

        assertEquals(0, rootDirectory.fileCount());
    }

    @Test
    public void storageWithDeepFileStructureShouldRemoveResource() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        rootDirectory.store(new File("foo.txt", 5));
        Directory foo = new Directory("foo");
        foo.store(new File("bar.mp1", 29));
        rootDirectory.store(foo);
        rootDirectory.remove(foo);

        assertEquals(1, rootDirectory.fileCount());
    }

    @Test
    public void directoryCanStoreDirectory() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        Resource yolo = new Directory("yolo");
        rootDirectory.store(yolo);

        assertEquals(1, rootDirectory.fileCount());
    }

    @Test
    public void emptyStorageShouldHaveSizeZero() {
        Storage storage = new Storage();

        assertEquals(0, storage.totalSize());
    }

    @Test
    public void storageWithFileShouldHaveSizeOfTheFile() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        File file = new File("foo.txt", 5);
        rootDirectory.store(file);

        assertEquals(5, storage.totalSize());
    }

    @Test
    public void storageWithDeepFileStructureShouldHaveSizeOfTheAllFiles() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        rootDirectory.store(new File("foo.txt", 5));
        Directory foo = new Directory("foo");
        foo.store(new File("bar.mp1", 29));
        rootDirectory.store(foo);

        assertEquals(34, storage.totalSize());
    }

    @Test
    public void storageCanCalculateNumberOfMp3Files() {
        Storage storage = new Storage();

        Directory rootDirectory = storage.rootDirectory();
        rootDirectory.store(new File("foo.mp3", 5));
        Directory foo = new Directory("foomp3");
        foo.store(new File("bar.mp3", 29));
        foo.store(new File("bar.rar", 9));
        rootDirectory.store(foo);

        assertEquals(2, storage.mp3FileCount());
    }

}
