package week4.day2;

import java.util.Arrays;

public class SquareAndSort {
    public static void main(){

    }

    public static int[] square(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = numbers[i] * numbers[i];
        }
        return numbers;
    }

    public static int[] sort(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if (numbers[i] > numbers[j]) {
                    numbers[i] = numbers[i] + numbers[j];
                    numbers[j] = numbers[i] - numbers[j];
                    numbers[i] = numbers[i] - numbers[j];
                }
            }
        }
        return numbers;
    }
}
