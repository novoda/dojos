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
        if (markedCorner()) {
            return;
        }
        
        if (markedSide()) {
            return;
        }
        
        for (int i = board.size() - 1; i >= 0; i--) {
            if (board.get(i).value == Mark.EMPTY) {
                int value = board.indexOf(board.get(i));
                print(value);
            }
        }
    }
    
    private boolean markedCorner() {
        if (empty(0)) {
            print(0);
            return true;
        }
        
        if (empty(2)) {
            print(2);
            return true;
        }
        
        if (empty(6)) {
            print(6);
            return true;
        }
        
        if (empty(8)) {
            print(8);
            return true;
        }
        
        return false;
    }
    
    private boolean markedSide() {
        if (empty(1)) {
            print(1);
            return true;
        }
        
        if (empty(3)) {
            print(3);
            return true;
        }
        
        if (empty(5)) {
            print(5);
            return true;
        }
        
        if (empty(7)) {
            print(7);
            return true;
        }
        
        return false;
    }
    
    private void print(int value) {
        System.out.println(value);
    }
    
    private boolean empty(int i) {
        return board.get(i).value == Mark.EMPTY;
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
