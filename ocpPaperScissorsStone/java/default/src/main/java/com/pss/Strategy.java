package com.pss;

public class Strategy {

  public Item beats(Item item1, Item item2) {
    if ("rock".equals(item1) && "sciccors".equals(item2)) {
      return item1;
    }
  }
}
