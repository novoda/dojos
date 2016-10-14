import java.util.ArrayList;
import java.util.List;

public class Game {
    
    private final List<Spot> board;
    private final Mark me;
    
    public Game(String... args) {
        board = new ArrayList<>(9);
        for (String value : args[0].split(",")) {
            Spot spot = new Spot(parseMark(value));
            board.add(spot);
        }
        me = parseMark(args[1]);
    }
    
    private Mark parseMark(String value) {
        if ("X".equals(value)) {
            return Mark.X;
        } else if ("0".equals(value)) {
            return Mark.O;
        } else {
            return Mark.EMPTY;
        }
    }
    
    public void go() {
        for (int i = board.size() -1 ; i >= 0; i--) {
            if (board.get(i).value == Mark.EMPTY) {
                System.out.println(board.indexOf(board.get(i)));
            }
        }
    }
    
    private final class Spot {
        
        private final Mark value;
        
        Spot(Mark value) {
            this.value = value;
        }
    }
    
    private enum Mark {
        X, O, EMPTY
    }
    
}
