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
        String score = "";
        int tempScore;
        if (score1 == score2) {
            switch (score1) {
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
        }
        else if (scoreExceedsForty()) {
            return calculateScoreOverForty();
        } else {
            for (int i=1; i<3; i++) {
                if (i==1) tempScore = score1;
                else { score+="-"; tempScore = score2;}
                switch(tempScore) {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String calculateScoreOverForty() {
        int minusResult = score1 - score2;
        if (minusResult==1) {
            return  "Advantage player1";
        } else if (minusResult ==-1) {
            return  "Advantage player2";
        } else if (minusResult>=2){
            return  "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private boolean scoreExceedsForty() {
        return score1 >=4 || score2 >=4;
    }
}
