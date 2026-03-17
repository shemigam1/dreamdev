import java.util.Scanner;
import java.lang.Math;

public class Arithmetic{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number 1");
    int num1 = input.nextInt();
    System.out.println("Input your number 2");
    int num2 = input.nextInt();
    System.out.println("Input your number 3");
    int num3 = input.nextInt();

    System.out.printf("%d is the sum of %d, %d, %d%n", num1+num2+num3, num1, num2, num3);
    System.out.printf("%d is the product of %d, %d, %d%n", num1*num2*num3, num1, num2, num3);
    System.out.printf("%d is the average of %d, %d, %d%n", (num1+num2+num3)/3, num1, num2, num3);

    int smallest = num1;
    if (smallest > num2) smallest = num2;
    if (smallest > num3) smallest = num3;

    System.out.printf("%d is the smallest of %d, %d, %d%n", smallest, num1, num2, num3);

    int largest = num1;
    if (largest < num2) largest = num2;
    if (largest < num3) largest = num3;

    System.out.printf("%d is the largest of %d, %d, %d%n", largest, num1, num2, num3);

  }
}
