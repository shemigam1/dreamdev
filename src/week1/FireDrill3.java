package week1;

import java.util.Scanner;

public class FireDrill3{
  public static void main(String... args){
    System.out.println("Welcome to the moniepoint money multiplier");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number");
    int num1 = scanner.nextInt();
    System.out.println("Enter a multiplier");
    int num2 = scanner.nextInt();
    int sum = 0;
    int mul = 1;
    if (num1 < 0 || num2 < 0) {
      mul = -1;
    }
    if (num1 < 0 && num2 < 0) {
      mul = 1;
    }
    for (int i = 0; i < Math.abs(num2); i++){
      sum += Math.abs(num1);
    }
    System.out.printf("%d%n", sum*mul);
  }
}
