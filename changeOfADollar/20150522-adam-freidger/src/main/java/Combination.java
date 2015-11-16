import java.util.HashMap;

public class Combination extends HashMap<Hiker.Coins, Integer> {

    public Combination() {
        super();
        put(Hiker.Coins.quarter, 0);
        put(Hiker.Coins.dime, 0);
        put(Hiker.Coins.nickel, 0);
        put(Hiker.Coins.penny, 0);
    }

    public Combination(int quarterCount, int dimeCount, int nickelCount, int pennyCount) {
        put(Hiker.Coins.quarter, quarterCount);
        put(Hiker.Coins.dime, dimeCount);
        put(Hiker.Coins.nickel, nickelCount);
        put(Hiker.Coins.penny, pennyCount);
    }

    public String getHashCodeString() {
        String hashCodeString = "";
        hashCodeString += String.format("%03d", get(Hiker.Coins.quarter));
        hashCodeString += String.format("%03d", get(Hiker.Coins.dime));
        hashCodeString += String.format("%03d", get(Hiker.Coins.nickel));
        hashCodeString += String.format("%03d", get(Hiker.Coins.penny));
        return hashCodeString;
    }

    public int hashCode() {

        return getHashCodeString().hashCode();
    }
}
