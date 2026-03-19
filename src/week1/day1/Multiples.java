package week1.day1;

import java.util.Scanner;
import java.lang.Math;

public class Multiples{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number 1");
    int num1 = input.nextInt();
    System.out.println("Input your number 2");
    int num2 = input.nextInt();

    int trip = (int) Math.pow(num1, 3);
    int doub = (int) Math.pow(num2, 2);
    boolean div = doub % trip == 0;

    if (div) System.out.printf("%d is a multiple of %d%n", trip, doub);
    if (!div) System.out.printf("%d is a fake number that is not a multiple of %d%n", trip, doub);

  }
}
