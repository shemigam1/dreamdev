package week1.day1;

import java.util.Scanner;
import java.lang.Math;

public class LargestSmallest{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number 1");
    int num1 = input.nextInt();
    System.out.println("Input your number 2");
    int num2 = input.nextInt();
    System.out.println("Input your number 3");
    int num3 = input.nextInt();
    System.out.println("Input your number 4");
    int num4 = input.nextInt();
    System.out.println("Input your number 5");
    int num5 = input.nextInt();

    int smallest = num1;
    if (smallest > num2) smallest = num2;
    if (smallest > num3) smallest = num3;
    if (smallest > num4) smallest = num4;
    if (smallest > num5) smallest = num5;
    System.out.printf("%d is the smallest of %d, %d, %d, %d, %d%n", smallest, num1, num2, num3, num4, num5);

    int largest = num1;
    if (largest < num2) largest = num2;
    if (largest < num3) largest = num3;
    if (largest < num4) largest = num4;
    if (largest < num5) largest = num5;

    System.out.printf("%d is the largest of %d, %d, %d, %d, %d%n", largest, num1, num2, num3, num4, num5);

  }
}
