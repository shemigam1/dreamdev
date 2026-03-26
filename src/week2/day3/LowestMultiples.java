package week2.day3;

import java.util.ArrayList;

public class LowestMultiples {
    public static ArrayList<Integer> getLowestMultiples(int number){
        ArrayList<Integer> factors = new ArrayList<>();
        int dummy = number;
        int i = 2;
        do {
            if (dummy % i == 0) {
                factors.add(i);
                dummy /= i;
            }
            else i++;
        } while (i <= dummy);
        return factors;
    }
}
