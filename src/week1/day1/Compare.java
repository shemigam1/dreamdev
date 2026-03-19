package week1.day1;

import java.util.Scanner;
import java.lang.Math;

public class Compare{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number");
    int num = input.nextInt();
    double power = Math.pow(num, 2);

    if (num > 100) System.out.printf("%d is greater than 100 %n", num);
    if (power > 100.0) System.out.printf("%f squared is greater than 100 %n", power);

    if (num == 100) System.out.printf("%d is equal to 100 %n", num);
    if (power == 100.0) System.out.printf("%f squared is equal to 100 %n", power);


    if (num < 100) System.out.printf("%d is less than 100 %n", num);
    if (power < 100.0) System.out.printf("%f squared is less than 100 %n", power);
  }
}
