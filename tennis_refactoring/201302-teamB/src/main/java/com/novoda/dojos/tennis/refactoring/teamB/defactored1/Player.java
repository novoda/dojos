package com.novoda.dojos.tennis.refactoring.teamB.defactored1;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Player {

    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public int getScore(){
        return score;
    }

    public void incrementScore(){
        score++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
