package com.novoda.workshop.rx;

import java.util.Iterator;

class IntegerIterator implements Iterator<Integer> {

    Integer counter = 0;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return counter++;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
