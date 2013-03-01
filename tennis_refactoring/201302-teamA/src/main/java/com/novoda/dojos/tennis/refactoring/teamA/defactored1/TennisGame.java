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
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
