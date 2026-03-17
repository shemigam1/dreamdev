import java.util.Scanner;
import java.lang.Math;

public class DivByThree{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number");
    int num = input.nextInt();
    boolean div = num % 3 == 0;

    if (div) System.out.printf("%d is divisible by 3%n", num);
    if (!div) System.out.printf("%d is a fake number that is not divisible by 3%n", num);

  }
}
