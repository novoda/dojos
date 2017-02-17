import java.util.Random;

public class Main {

    private final String key;
    private final String[] board;

    private static final int[][] CORNERS = new int[][]{
            new int[]{0, 0},
            new int[]{0, 2},
            new int[]{2, 0},
            new int[]{2, 2}
    };
    private static final int[][] MIDDLES = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{1, 2},
            new int[]{2, 1}
    };

    Main(String key, String[] board) {
        this.key = key;
        this.board = board;
    }

    public static void main(String[] args) {
        Main main = new Main("X", "-,X,-,-,X,X,-,0,-".split(","));
        main.play();
    }

    private void play() {

        if (isEmpty(1, 1)) {
            printAt(1, 1);
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isEmpty(i, j) && canWin(i, j)) {
                    printAt(i, j);
                    return;
                }
            }
        }

        Random random = new Random();
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (isEmpty(x, y)) {
                printAt(x, y);
                return;
            }
        }

//        for (int[] corner : CORNERS) {
//            if (isEmpty(corner[0], corner[1])) {
//
//            }
//        }

    }

    private void printAt(int x, int y) {
        System.out.print(indexAt(x, y));
    }

    private String charAt(int x, int y) {
        return board[indexAt(x, y)];
    }

    private void placeAt(int x, int y) {
        board[indexAt(x, y)] = key;
    }

    private void removeAt(int x, int y) {
        board[indexAt(x, y)] = "-";
    }

    private int indexAt(int x, int y) {
        return 3 * x + y;
    }

    private boolean isOurs(int x, int y) {
        return key.equals(charAt(x, y));
    }

    private boolean isEmpty(int x, int y) {
        return "-".equals(charAt(x, y));
    }

    private boolean canWin(int x, int y) {
        String value = charAt(x, y);
        placeAt(x, y);
        boolean canWin = isHorizontalWin() || isVerticalWin() || isDiagonalWin();
        removeAt(x, y);
        return canWin;
    }

    private boolean isHorizontalWin() {
        return isHorizontalWin(0) || isHorizontalWin(1) || isHorizontalWin(2);
    }

    private boolean isHorizontalWin(int row) {
        return isOurs(row, 0) && isOurs(row, 1) && isOurs(row, 2);
    }

    private boolean isVerticalWin() {
        return isVerticalWin(0) || isVerticalWin(1) || isVerticalWin(2);
    }

    private boolean isVerticalWin(int column) {
        return isOurs(0, column) && isOurs(1, column) && isOurs(2, column);
    }

    private boolean isDiagonalWin() {
        return (isOurs(0, 0) && isOurs(1, 1) && isOurs(2, 2))
                || (isOurs(0, 2) && isOurs(1, 1) && isOurs(2, 0));
    }

}
