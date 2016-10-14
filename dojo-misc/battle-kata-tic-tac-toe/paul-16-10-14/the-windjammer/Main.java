public class Main {

    /**
     * Arg 1 - The board as a comma separated string. - is unplayed. -,X,-,0,-,X,-,0,-
     * <p/>
     * Arg 2 - The player key, X or 0. It's a Zero/0 !
     * <p/>
     * Playing a move : print out a single board index to the console. 0 - 8.
     */
    public static void main(String[] args) {
        String[] board = args[0].split(",");
        System.out.println(getPosition(board));
    }

    static int getPosition(String[] board) {
        for (int i = 0; i < board.length; i++) {
            String position = board[i];
            if (position.equals("-")) {
                return i;
            }
        }
        return 0;
    }

}
