package week2.day2;

import java.util.ArrayList;
import java.util.Scanner;

public class LcmGenerator {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers will you enter");
        int quantity = scanner.nextInt();
        int[] numbers = new int[quantity];
        for (int i = 0; i < quantity; i++){
            System.out.printf("Enter number %d", i + 1);
            int num = scanner.nextInt();
            numbers[i] = num;
        }
        int lcm = LCM(numbers);
        System.out.printf("LCM is %d", lcm);


    }
    public static int LCM(int[] numbers) {
        int factor = 2;
        ArrayList<Integer> factors = new ArrayList<>();
        do {
            boolean isFactor = false;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) return 0;
                if (Math.abs(numbers[i]) % factor == 0) {
                    isFactor = true;
                    numbers[i] = Math.abs(numbers[i]) / factor;
                }
            }
            if (isFactor) factors.add(factor);
            else factor++;

        } while (!checkOnes(numbers));
        int mul = 1;
        for (int num : factors){
            mul *= num;
        }
        return mul;
    }

    public static boolean checkOnes(int[] numbers){
        for (int num : numbers){
            if (num != 1) return false;
        }
        return true;
    }
}
