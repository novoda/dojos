package com.novoda.dojos.tennis.refactoring.teamB.defactored1;

public class TennisGame {

    private final Player one;
    private final Player two;
    private int score1 = 0;
    private int score2 = 0;

    public TennisGame(Player one, Player two) {
        this.one = one;
        this.two = two;
    }

    public void wonPoint(Player player) {
        if (player.equals(one))
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        if (playerScoresAreEqual()) {
            return calculateEqualScore();
        } else if (aPlayerScoreExceedsForty()) {
            return calculateScoreOverForty();
        } else {
            return calculateNormalScore();
        }
    }

    private boolean playerScoresAreEqual() {
        return score1 == score2;
    }

    private String calculateEqualScore() {
        switch (score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }
    }

    private boolean aPlayerScoreExceedsForty() {
        return score1 >= 4 || score2 >= 4;
    }

    private String calculateScoreOverForty() {
        int pointDifference = score1 - score2;
        if (pointDifference == 1) {
            return "Advantage player1";
        } else if (pointDifference == -1) {
            return "Advantage player2";
        } else if (pointDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String calculateNormalScore() {
        return getTextScoreFor(score1) + "-" + getTextScoreFor(score2);
    }

    private String getTextScoreFor(int tempScore) {
        return Score.values()[tempScore].name();
    }

    enum Score {
        Love,
        Fifteen,
        Thirty,
        Forty;
    }
}
