package week2.day3;

import java.util.ArrayList;

public class Factors {
    public static ArrayList<Integer> getFactors(int number){
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++){
            if (number % i == 0) factors.add(i);
        }
        return factors;
    }
}
