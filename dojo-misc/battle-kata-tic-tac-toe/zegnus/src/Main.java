public class Main {

    public static void main(String[] args) {
//        args = new String[2];
//        args[0] = "-,-,-,-,-,-,-,-,-";
//        args[1] = "X";

        String[] board = args[0].split(",");
        String player = args[1];

        if (firstToMove(board)) {
            System.out.println("4");
        } else if (secondToMoveAndFreeTopLeft(board, player)) {
            System.out.print("2");
        } else {
            System.out.println(findNextMove(board, player));
        }
    }

    private static boolean firstToMove(String[] board) {
        for (int i = 0; i < 9; i++) {
            if (!board[i].equals("-")) {
                return false;
            }
        }

        return true;
    }

    private static boolean secondToMoveAndFreeTopLeft(String[] board, String player) {
        int numberOfOpponentPosition = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(player)) {
                numberOfOpponentPosition++;
            }
        }

        return numberOfOpponentPosition == 1 && board[2].equals("-");
    }

    private static String findNextMove(String[] board, String player) {
        int nextFreePosition = findNextFreePosition(board);
        return String.valueOf(nextFreePosition);
    }

    private static int findNextFreePosition(String[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i].equals("-")) {
                return i;
            }
        }

        return -1;
    }

    private static boolean win(String[] board, String player) {
        return anyRow(board, player) || anyColumn(board, player) || anyDiagonal(board, player);
    }

    private static boolean anyRow(String[] board, String player) {
        return rowCheck(0, board,  player)
                || rowCheck(3, board,  player)
                || rowCheck(6, board,  player);
    }

    private static boolean rowCheck(int offset, String[] board, String player) {
        return board[offset].equals(player) && board[1 + offset].equals(player) && board[2 + offset].equals(player);
    }

    private static boolean anyColumn(String[] board, String player) {
        return columnCheck(0, board,  player)
                || columnCheck(1, board,  player)
                || columnCheck(2, board,  player);
    }

    private static boolean columnCheck(int offset, String[] board, String player) {
        return board[offset].equals(player) && board[3 + offset].equals(player) && board[6 + offset].equals(player);
    }

    private static boolean anyDiagonal(String[] board, String player) {
        return firstDiagonal(board,  player) || secondDiagonal(board,  player);
    }

    private static boolean firstDiagonal(String[] board, String player) {
        return board[0].equals(player) && board[4].equals(player) && board[8].equals(player);
    }

    private static boolean secondDiagonal(String[] board, String player) {
        return board[2].equals(player) && board[4].equals(player) && board[6].equals(player);
    }
}
