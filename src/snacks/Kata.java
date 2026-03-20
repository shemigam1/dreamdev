package snacks;

public class Kata {
    public static boolean isEven(int number){
        if (number % 2 == 0) return true;
        return false;
    }

    public static boolean isPrimeNumber(int number){
        if (number < 2) return false;

        for (int i = 2; i < Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }
        return true;
    }
}
