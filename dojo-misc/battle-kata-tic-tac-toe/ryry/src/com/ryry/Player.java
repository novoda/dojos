package com.ryry;

public class Player {

    static Player PLAYER_ONE = new Player("0");
    static Player PLAYER_TWO = new Player("X");
    
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

}
