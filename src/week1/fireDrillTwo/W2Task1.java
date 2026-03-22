package week1.fireDrillTwo;

import java.util.Scanner;

public class W2Task1 {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number");
    int counter = 0;
    int sum = 0;
    while (counter < 10){
      int num1 = scanner.nextInt();
      sum += num1;
      ++counter;
    }
    System.out.println(sum);
  }
}
