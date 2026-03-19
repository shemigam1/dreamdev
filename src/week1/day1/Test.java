package week1.day1;

import java.util.Scanner;

public class Test{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number");
    int num = input.nextInt();

    if (num % 2 == 0) System.out.printf("%d is even %n", num);

    if (num % 2 != 0) System.out.printf("%d is odd %n", num);
  }
}
