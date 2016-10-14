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
        int positionToPlay = getWinningMove(key, board);

        if (positionToPlay == NO_AVAILABLE_MOVE) {
            positionToPlay = getAnyOpenPosition(board);
        }

        System.out.println(positionToPlay);
    }

    private static int getWinningMove(String key, String[] board) {

        // right column win

        if (board[0].equals(key)) {
            if (board[1].equals(key)) {
                return 2;
            }
        }

        if (board[3].equals(key)) {
            if (board[4].equals(key)) {
                return 5;
            }
        }

        if (board[6].equals(key)) {
            if (board[7].equals(key)) {
                return 8;
            }
        }

        // middle column win

        if (board[0].equals(key)) {
            if (board[2].equals(key)) {
                return 1;
            }
        }

        if (board[3].equals(key)) {
            if (board[5].equals(key)) {
                return 4;
            }
        }

        if (board[6].equals(key)) {
            if (board[8].equals(key)) {
                return 7;
            }
        }

        // first column win

        if (board[2].equals(key)) {
            if (board[1].equals(key)) {
                return 0;
            }
        }

        if (board[5].equals(key)) {
            if (board[4].equals(key)) {
                return 3;
            }
        }

        if (board[8].equals(key)) {
            if (board[7].equals(key)) {
                return 6;
            }
        }

        // bottom row win

        if (board[0].equals(key)) {
            if (board[3].equals(key)) {
                return 6;
            }
        }

        if (board[1].equals(key)) {
            if (board[4].equals(key)) {
                return 8;
            }
        }

        if (board[2].equals(key)) {
            if (board[5].equals(key)) {
                return 8;
            }
        }

        // middle row win

        if (board[0].equals(key)) {
            if (board[6].equals(key)) {
                return 3;
            }
        }

        if (board[1].equals(key)) {
            if (board[8].equals(key)) {
                return 4;
            }
        }

        if (board[2].equals(key)) {
            if (board[8].equals(key)) {
                return 5;
            }
        }

        // left row win

        if (board[6].equals(key)) {
            if (board[3].equals(key)) {
                return 0;
            }
        }

        if (board[8].equals(key)) {
            if (board[4].equals(key)) {
                return 1;
            }
        }

        if (board[8].equals(key)) {
            if (board[5].equals(key)) {
                return 2;
            }
        }

        // right diagonal win

        if (board[0].equals(key)) {
            if (board[4].equals(key)) {
                return 8;
            }
        }

        if (board[4].equals(key)) {
            if (board[8].equals(key)) {
                return 0;
            }
        }

        if (board[8].equals(key)) {
            if (board[0].equals(key)) {
                return 4;
            }
        }

        // left diagonal win

        if (board[2].equals(key)) {
            if (board[4].equals(key)) {
                return 6;
            }
        }

        if (board[4].equals(key)) {
            if (board[6].equals(key)) {
                return 2;
            }
        }

        if (board[6].equals(key)) {
            if (board[2].equals(key)) {
                return 4;
            }
        }

        // else

        return NO_AVAILABLE_MOVE;
    }

    static int getAnyOpenPosition(String[] board) {
        for (int i = 0; i < board.length; i++) {
            String position = board[i];
            if (position.equals("-")) {
                return i;
            }
        }
        return 0;
    }

}
