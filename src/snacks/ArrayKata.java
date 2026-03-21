package snacks;

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
}
