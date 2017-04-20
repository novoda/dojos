package com.novoda.rul;

import java.util.List;

/**
 * 1 - Paul
 * 2 - Luis
 * 3 - Xavi
 */
class RecentlyUsedList {

    private final List<String> items;

    RecentlyUsedList(List<String> items) {
        this.items = items;
    }

    void add(String item) {
        //removeDupes(item);
        items.remove(item);
        items.add(0, item);
    }

    private void removeDupes(String item) {
        for (int i = 0; i < items.size(); i++) {
            String possDupe = items.get(i);
            if(possDupe.equals(item)) {
                items.remove(i);
            }
        }
    }

    int size() {
        return items.size();
    }

    String get(int index) {
        return items.get(index);
    }
}
