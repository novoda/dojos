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

        int positionToPlay = findPositionToPlay(board, key);

        if (isEmpty(board[positionToPlay])) {
            System.out.println(positionToPlay);
        } else {
            throw new RuntimeException("Draw Game!");
        }
    }

    static int findPositionToPlay(String[] board, String key) {
        int positionToPlay = findDefensiveBlockMove(key, board);

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = findWinningMove(key, board);
        }

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = findMiddleMove(board);
        }

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = findCornerMove(board);
        }

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = findAnyOpenPosition(board);
        }

        return positionToPlay;
    }

    private static int findDefensiveBlockMove(String key, String[] board) {
        return findWinningMove(key.equals("X") ? "0" : "X", board);
    }

    private static int findWinningMove(String key, String[] board) {
        return getAvailableThirdMoveInARow(key, board);
    }

    private static int getAvailableThirdMoveInARow(String key, String[] board) {
        // first column win

        if (isPositionAvailable(key, board[2], board[1], board[0])) {
            return 0;
        }

        if (isPositionAvailable(key, board[5], board[4], board[3])) {
            return 3;
        }

        if (isPositionAvailable(key, board[8], board[7], board[6])) {
            return 6;
        }

        // middle column win

        if (isPositionAvailable(key, board[0], board[2], board[1])) {
            return 1;
        }

        if (isPositionAvailable(key, board[3], board[5], board[4])) {
            return 4;
        }

        if (isPositionAvailable(key, board[6], board[8], board[7])) {
            return 7;
        }

        // right column win

        if (isPositionAvailable(key, board[0], board[1], board[2])) {
            return 2;
        }

        if (isPositionAvailable(key, board[3], board[4], board[5])) {
            return 5;
        }

        if (isPositionAvailable(key, board[6], board[7], board[8])) {
            return 8;
        }

        // top row win

        if (isPositionAvailable(key, board[6], board[3], board[0])) {
            return 0;
        }

        if (isPositionAvailable(key, board[8], board[4], board[1])) {
            return 1;
        }

        if (isPositionAvailable(key, board[8], board[5], board[2])) {
            return 2;
        }

        // middle row win

        if (isPositionAvailable(key, board[0], board[6], board[3])) {
            return 3;
        }

        if (isPositionAvailable(key, board[1], board[8], board[4])) {
            return 4;
        }

        if (isPositionAvailable(key, board[2], board[8], board[5])) {
            return 5;
        }

        // bottom row win

        if (isPositionAvailable(key, board[0], board[3], board[6])) {
            return 6;
        }

        if (isPositionAvailable(key, board[1], board[4], board[7])) {
            return 7;
        }

        if (isPositionAvailable(key, board[2], board[5], board[8])) {
            return 8;
        }

        // right diagonal win

        if (isPositionAvailable(key, board[0], board[4], board[8])) {
            return 8;
        }

        if (isPositionAvailable(key, board[8], board[0], board[4])) {
            return 4;
        }

        if (isPositionAvailable(key, board[4], board[8], board[0])) {
            return 0;
        }

        // left diagonal win

        if (isPositionAvailable(key, board[2], board[4], board[6])) {
            return 6;
        }

        if (isPositionAvailable(key, board[6], board[2], board[4])) {
            return 4;
        }

        if (isPositionAvailable(key, board[4], board[6], board[2])) {
            return 2;
        }

        // else

        return NO_AVAILABLE_MOVE;
    }

    private static boolean isPositionAvailable(String key, String move1, String move2, String move3) {
        return move1.equals(key) && move2.equals(key) && isEmpty(move3);
    }

    static int findMiddleMove(String[] board) {
        if (isEmpty(board[4])) {
            return 4;
        }

        return NO_AVAILABLE_MOVE;
    }

    private static int findCornerMove(String[] board) {
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

    static int findAnyOpenPosition(String[] board) {
        for (int i = 0; i < board.length; i++) {
            String position = board[i];
            if (isEmpty(position)) {
                return i;
            }
        }
        return 0;
    }

}
