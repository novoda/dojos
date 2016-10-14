public class Main {

    private static final int NO_AVAILABLE_MOVE = -1;

    /**
     * Arg 1 - The board as a comma separated string. - is unplayed. -,X,-,0,-,X,-,0,-
     * <p/>
     * Arg 2 - The player key, X or 0. It's a Zero/0 !
     * <p/>
     * Playing a move : print out a single board index to the console. 0 - 8.
     */
    public static void main(String[] args) {
        String[] board = args[0].split(",");
        String key = args[1];

        int positionToPlay = getPositionToPlay(board, key);

        if (isEmpty(board[positionToPlay])) {
            System.out.println(positionToPlay);
        } else {
            throw new RuntimeException("Draw Game!");
        }
    }

    static int getPositionToPlay(String[] board, String key) {
        int positionToPlay = getDefensiveBlockMove(key, board);

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = getWinningMove(key, board);
        }

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = getMiddleMove(board);
        }

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = getCornerMove(board);
        }

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = getAnyOpenPosition(board);
        }

        return positionToPlay;
    }

    private static int getDefensiveBlockMove(String key, String[] board) {
        return getWinningMove(key.equals("X") ? "0" : "X", board);
    }

    private static int getWinningMove(String key, String[] board) {
        return getAvailableThirdMoveInARow(key, board);
    }

    static int getMiddleMove(String[] board) {
        if (isEmpty(board[4])) {
            return 4;
        }

        return NO_AVAILABLE_MOVE;
    }

    private static int getCornerMove(String[] board) {
        if (isEmpty(board[8])) {
            return 8;
        }

        if (isEmpty(board[6])) {
            return 6;
        }

        if (isEmpty(board[2])) {
            return 2;
        }

        if (isEmpty(board[0])) {
            return 0;
        }

        return NO_AVAILABLE_MOVE;
    }

    private static boolean isEmpty(String s) {
        return s.equals("-");
    }

    private static int getAvailableThirdMoveInARow(String key, String[] board) {
        // right column win

        if (isWinAvailable(key, board[0], board[1])) {
            return 2;
        }

        if (isWinAvailable(key, board[3], board[4])) {
            return 5;
        }

        if (isWinAvailable(key, board[6], board[7])) {
            return 8;
        }

        // middle column win

        if (isWinAvailable(key, board[0], board[2])) {
            return 1;
        }

        if (isWinAvailable(key, board[3], board[5])) {
            return 4;
        }

        if (isWinAvailable(key, board[6], board[8])) {
            return 7;
        }

        // first column win

        if (isWinAvailable(key, board[2], board[1])) {
            return 0;
        }

        if (isWinAvailable(key, board[5], board[4])) {
            return 3;
        }

        if (isWinAvailable(key, board[8], board[7])) {
            return 6;
        }

        // bottom row win

        if (isWinAvailable(key, board[0], board[3])) {
            return 6;
        }

        if (isWinAvailable(key, board[1], board[4])) {
            return 8;
        }

        if (isWinAvailable(key, board[2], board[5])) {
            return 8;
        }

        // middle row win

        if (isWinAvailable(key, board[0], board[6])) {
            return 3;
        }

        if (isWinAvailable(key, board[1], board[8])) {
            return 4;
        }

        if (isWinAvailable(key, board[2], board[8])) {
            return 5;
        }

        // left row win

        if (isWinAvailable(key, board[6], board[3])) {
            return 0;
        }

        if (isWinAvailable(key, board[8], board[4])) {
            return 1;
        }

        if (isWinAvailable(key, board[8], board[5])) {
            return 2;
        }

        // right diagonal win

        if (isWinAvailable(key, board[0], board[4])) {
            return 8;
        }

        if (isWinAvailable(key, board[4], board[8])) {
            return 0;
        }

        if (isWinAvailable(key, board[8], board[0])) {
            return 4;
        }

        // left diagonal win

        if (isWinAvailable(key, board[2], board[4])) {
            return 6;
        }

        if (isWinAvailable(key, board[4], board[6])) {
            return 2;
        }

        if (isWinAvailable(key, board[6], board[2])) {
            return 4;
        }

        // else

        return NO_AVAILABLE_MOVE;
    }

    private static boolean isWinAvailable(String key, String move1, String move2) {
        return move1.equals(key) && move2.equals(key);
    }

    static int getAnyOpenPosition(String[] board) {
        for (int i = 0; i < board.length; i++) {
            String position = board[i];
            if (isEmpty(position)) {
                return i;
            }
        }
        return 0;
    }

}
