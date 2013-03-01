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
        String score;
        switch (playerOneScore) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private boolean eitherScoreOverFourty() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private String determineAdvantageOrWin() {
        String score;
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
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
