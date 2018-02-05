package com.pss;

public class PaperScissorsStone {

    public Move result(Move firstMove, Move secondMove) {
        return firstMove.accept(secondMove);
    }

    static class Scissors extends Move {
        @Override
        Move accept(Visitor visitor) {
            return visitor.visit(this);
        }

        @Override
        public Move visit(Paper paper) {
            return this;
        }

        @Override
        public Move visit(Scissors scissors) {
            return this;
        }

        @Override
        public Move visit(Stone stone) {
            return stone;
        }
    }

    static class Paper extends Move {
        @Override
        Move accept(Visitor visitor) {
            return visitor.visit(this);
        }

        @Override
        public Move visit(Paper paper) {
            return this;
        }

        @Override
        public Move visit(Scissors scissors) {
            return scissors;
        }

        @Override
        public Move visit(Stone stone) {
            return this;
        }
    }

    static class Stone extends Move {
        @Override
        Move accept(Visitor visitor) {
            return visitor.visit(this);
        }

        @Override
        public Move visit(Paper paper) {
            return paper;
        }

        @Override
        public Move visit(Scissors scissors) {
            return this;
        }

        @Override
        public Move visit(Stone stone) {
            return this;
        }
    }

}
