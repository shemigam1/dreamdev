package snacks.week1;

import java.util.ArrayList;

public class ArrayKata {
    public static int maximumIn(int[] arrayOfIntegers){
        int max = Integer.MIN_VALUE;
        for (int num : arrayOfIntegers){
            if (num > max) max = num;
        }
        return max;
    }

    public static int minimumIn(int[] arrayOfIntegers){
        int min = Integer.MAX_VALUE;
        for (int num : arrayOfIntegers){
            if (num < min) min = num;
        }
        return min;
    }

    public static int sumOf(int[] arrayOfIntegers){
        int sum = 0;
        for (int num : arrayOfIntegers){
            sum += num;
        }
        return sum;
    }

    public static int sumOfEvenNumbersIn(int[] arrayOfIntegers){
        int sum = 0;
        for (int num : arrayOfIntegers){
            if (num % 2 == 0) sum += num;
        }
        return sum;
    }

    public static int sumOfOddNumbersIn(int[] arrayOfIntegers){
        int sum = 0;
        for (int num : arrayOfIntegers){
            if (num % 2 != 0) sum += num;
        }
        return sum;
    }

    public static int[] maximumAndMinimumOf(int[] arrayOfIntegers){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arrayOfIntegers){
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new int[] {min, max};
    }

    public static int noOfOddNumbersIn(int[] arrayOfIntegers){
        int sum = 0;
        for (int num : arrayOfIntegers){
            if (num % 2 != 0) sum += 1;
        }
        return sum;
    }

    public static int noOfEvenNumbersIn(int[] arrayOfIntegers){
        int sum = 0;
        for (int num : arrayOfIntegers){
            if (num % 2 == 0) sum += 1;
        }
        return sum;
    }

    public static ArrayList<Integer> evenNumbersIn(int[] arrayOfIntegers){
        ArrayList<Integer> even = new ArrayList<>();
        
        for (int num : arrayOfIntegers){
            if (num % 2 == 0) even.add(num);
        }
        return even;
    }

    public static ArrayList<Integer> oddNumbersIn(int[] arrayOfIntegers){
        ArrayList<Integer> odd = new ArrayList<>();

        for (int num : arrayOfIntegers){
            if (num % 2 != 0) odd.add(num);
        }
        return odd;
    }

    public static ArrayList<Integer> squareNumbersIn(int[] arrayOfIntegers){
        ArrayList<Integer> square = new ArrayList<>();

        for (int num : arrayOfIntegers){
            square.add(num*num);
        }
        return square;
    }
}
