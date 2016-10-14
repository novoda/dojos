/*
 
 The bots will recieve two arguments to their main function.
 
 Arg 1 - The board as a comma separated string. - is unplayed. -,X,-,0,-,X,-,0,-
 
 [ 0 | 1 | 2 ]
 [ 3 | 4 | 5 ]
 [ 6 | 7 | 8 ]
 
 Arg 2 - The player key, X or 0. It's a Zero/0 !
 
 */

public class Main {
    
    public static void main(String... betterThanPaul) {
        try {
            Game game = new Game(betterThanPaul);
            game.go();
        } catch (Exception yolo) {
            System.out.println("0");
        }
    }
    
}
