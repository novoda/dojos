package com.pss;

public class Factory {

  public static Item create(boolean strategy) {
    return new Item(strategy);
  }
}
