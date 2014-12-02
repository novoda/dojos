package com.novoda.shopping;

import java.util.List;

public interface Storage<T> {

    List<T> retrieveAll();

}
