package com.novoda.dojos.tennis.refactoring.teamA.defactored1;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    public String getScore() {
        if (scoresAreEqual()) {
            return determineDrawScore();
        } else if (eitherScoreOverFourty()) {
            return determineAdvantageOrWin();
        } else {
            return determineNonDrawScore();
        }
    }

    private boolean scoresAreEqual() {
        return playerOneScore == playerTwoScore;
    }

    private String determineDrawScore() {
        switch (playerOneScore) {
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

    private boolean eitherScoreOverFourty() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private String determineAdvantageOrWin() {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";

    }

    private String determineNonDrawScore() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = playerOneScore;
            } else {
                score += "-";
                tempScore = playerTwoScore;
            }
            score += getDescriptionFor(tempScore);
        }
        return score;
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
                return "fail";
        }
    }
}
