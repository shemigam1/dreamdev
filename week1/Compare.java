import java.util.Scanner;

public class Compare{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your number");
    int num = input.nextInt();

    if (num > 100) System.out.printf("%d is greater than 100 %n", num);
    if (num**2 > 100) System.out.printf("%d squared is greater than 100 %n", num**2);

    if (num == 100) System.out.printf("%d is equal to 100 %n", num);
    if (num**2 == 100) System.out.printf("%d squared is equal to 100 %n", num**2);


    if (num < 100) System.out.printf("%d is less than 100 %n", num);
    if (num**2 < 100) System.out.printf("%d squared is less than 100 %n", num**2);
  }
}
