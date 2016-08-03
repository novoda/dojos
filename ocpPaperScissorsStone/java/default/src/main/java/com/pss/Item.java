package com.pss;

public class Item {

  private final boolean winner;

  public Item(boolean winner) {
    this.winner = winner;
  }

  public boolean beats(Item other) {
    return winner;
  }
}
