import java.util.Set;
import java.util.HashSet;

public class Hiker {

    public enum Coins {
      quarter(25),
      dime(10),
      nickel(5), 
      penny(1);
       
      int value;

      Coins(int value) {
        this.value = value;
      }
    }  

    
    public static Set<Combination> calculate (int givenAmount) {
      Set<Combination> combinations = new HashSet<Combination>();

int i = 0;
int j = 0;
int k = 0;

     // for (int i = 0; i * Coins.quarter.value <= givenAmount; i++) {
     // for (int j = 0; j * Coins.dime.value <= givenAmount; j++) {
     // for (int k = 0; k * Coins.nickel.value <= givenAmount; k++) {
      for (int l = 0; l * 1 <= givenAmount; l++) {
         int sum = i * Coins.quarter.value
            + j * Coins.dime.value
            + k * Coins.nickel.value
            + l * Coins.penny.value;
        if (sum == givenAmount) {
          Combination combination = new Combination(i, j, k, l);
          combinations.add(combination);
        }
      }
      //}
      //}
      //}

      return combinations;
    }
}
