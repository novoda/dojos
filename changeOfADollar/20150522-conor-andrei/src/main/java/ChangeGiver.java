
public class ChangeGiver {

    public static int getTotalNumberOfWays(int cents) {
        int ways = 0;
        if (cents > 5) {
            ways = getTotalNumberOfWays(cents - 5) 
                + getTotalNumberOfWays(cents - 1);
        } else if (cents == 5) {
            ways = 1 + getTotalNumberOfWays(cents - 1) ;
        } else if (cents > 0) {
            ways = 1;
        }  
        return ways;      
    }

}