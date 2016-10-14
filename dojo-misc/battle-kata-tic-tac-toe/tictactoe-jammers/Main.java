import java.util.List;
import java.util.ArrayList;

public class Main {

    public static final String AVAILABLE = "-";
    public static final int CENTRAL_POSITION = 4;

    public static void main(String[] args) {
        String board = args[0];
        String key = args[1];
        String[] splitBoard = board.split(",");
        
        String[][] boardMatrix = {
                {splitBoard[0], splitBoard[1], splitBoard[2]},
                {splitBoard[3], splitBoard[4], splitBoard[5]},
                {splitBoard[6], splitBoard[7], splitBoard[8]},
        };


//        System.out.println(board);
//        System.out.println(key);
//        System.out.println();
//        System.out.print(boardMatrix[0][0] + " ");
//        System.out.print(boardMatrix[0][1] + " ");
//        System.out.print(boardMatrix[0][2]);
//        System.out.println();
//        System.out.print(boardMatrix[1][0] + " ");
//        System.out.print(boardMatrix[1][1] + " ");
//        System.out.print(boardMatrix[1][2]);
//        System.out.println();
//        System.out.print(boardMatrix[2][0] + " ");
//        System.out.print(boardMatrix[2][1] + " ");
//        System.out.print(boardMatrix[2][2]);
//        System.out.println();

        List<Integer> availablePositionsToPlay = availablePositionsToPlay(boardMatrix);

        int best = getBestPositionFrom(availablePositionsToPlay);
        System.out.println("" + best);
    }

    private static List<Integer> availablePositionsToPlay(String[][] boardMatrix) {
        List<Integer> availablePositions = new ArrayList<Integer>();
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                String position = boardMatrix[i][j];
                if (AVAILABLE.equals(position)) {
                    availablePositions.add(positionFor(i, j));
                }
            }
        }
        return availablePositions;
    }

    private static int positionFor(int x, int y) {
        int result = x * 3 + y;
//        System.out.println("Position for " + x + ", " + y + " --> " + result);
        return result;
    }

    private static int getBestPositionFrom(List<Integer> availablePositions) {
        if (availablePositions.contains(CENTRAL_POSITION)) {
            return CENTRAL_POSITION;
        } else {
            return availablePositions.get(0);
        }
    }

}
