package com.novoda.dojos.tennis.refactoring.teamA.defactored1;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    public String getScore() {
        if (eitherScoreOverFourty()) {
            return determineAdvantageOrWin();
        }
        return determineDrawScore();
    }

    private boolean eitherScoreOverFourty() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private String determineAdvantageOrWin() {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 0) {
            return "Deuce";
        } else if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";

    }

    private boolean scoresAreEqual() {
        return playerOneScore == playerTwoScore;
    }

    private String determineDrawScore() {
        if (scoresAreEqual()) {
            return getDescriptionFor(playerOneScore) + "-" + "All";
        }
        return getDescriptionFor(playerOneScore) + "-" + getDescriptionFor(playerTwoScore);
    }

    private String getDescriptionFor(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new RuntimeException("You suck " + score + " times");
        }
    }
}
