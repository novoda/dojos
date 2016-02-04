import java.util.ArrayList;
import java.util.List;

class DigitSplitter {

    /*
        120 % 10 = 0, 120 / 10 = 12
        12 % 10 = 2, 12 / 10 = 1
        1 % 10 = 1, 1 / 10 = 0
         */

    public List<Integer> split(int number) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int moduleResult, divisionResult;

        divisionResult = number;
        while (divisionResult != 0)  {
            moduleResult = divisionResult % 10;
            divisionResult = divisionResult / 10;
            list.add(0, moduleResult);
        }

        /*list.add(1);
        list.add(2);
        list.add(0);*/

        return list;
    }

}
