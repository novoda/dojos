package com.novoda;

import java.util.ArrayList;
import java.util.List;

public class RecentsList {


    private List<String> list;

    public RecentsList() {
        this.list = new ArrayList<String>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void put(String string) {
        list.add(string);
    }

    public String get(int index) {
        return list.get(list.size() - index - 1);
    }
}
