import java.util.Scanner;
import java.lang.Math;

public class Arithmetic{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number");
    int num1 = input.nextInt();
    int num2 = input.nextInt();
    double power1 = Math.pow(num1, 2);
    double power2 = Math.pow(num2, 2);

    System.out.printf("%f is the power to 2 of %d%n", power1, num1);
    System.out.printf("%f is the power to 2 of %d%n", power2, num2);

    System.out.printf("%f + %f =  %f%n", power1, power2, power1+power2);
    System.out.printf("%f - %f =  %f%n", power1, power2, power1-power2);

  }
}
