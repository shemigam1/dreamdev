package snacks.week1;

import java.util.Objects;

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

    public static boolean isSquare(int number){
        if (number == 0) return false;
        int root = (int) Math.sqrt(number);
        return (root * root) == number;
    }

    public static boolean isPalindrome(int number){
        String num = String.valueOf(number);
        String[] arr = num.split("");
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (!Objects.equals(arr[left], arr[right])) return false;
            left++;
            right--;
        }
        return true;
    }

    public static long factorial(int number){
        if (number <= 1) return 1;
        return number * factorial(number - 1);
    }

    public static long squareOf(int number){
        return (long) number * number;
    }
}
