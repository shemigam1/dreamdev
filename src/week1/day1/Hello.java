package week1.day1;

import java.util.Scanner;

public class Hello {
  public static void main(String[] args){
    System.out.print("Welcome to DreamDev\n");

    Scanner input = new Scanner(System.in);
    System.out.println("enter first number:" );
    int firstNum = input.nextInt();

    System.out.println("enter second number:" );
    int secondNum = input.nextInt();
    int sum = firstNum + secondNum;

    System.out.printf("the sum of %d and %d is %d", firstNum, secondNum, sum);
  }
}
