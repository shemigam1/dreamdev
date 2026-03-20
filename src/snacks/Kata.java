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

    public static int subtract(int num1, int num2){
        return Math.abs(num1 - num2);
    }

    public static float divide(int num1, int num2){
        if (num2 == 0) return 0;
        return (float) num1 / num2;
    }

    public static int factorOf(int number){
        int factors = 0;
        for (int i = 1; i <= number; i++){
            if (number % i == 0) factors++;
        }
        return factors;
    }
}
