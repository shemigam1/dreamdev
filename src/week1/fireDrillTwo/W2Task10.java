import java.util.Scanner;

public class W2Task10 {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number");
    int counter = 1;
    int sum = 0;
    for (;counter <= 10; counter++){
      int num1 = scanner.nextInt();
      if ((num1 >= 0 || num1 <= 100)){
        sum += num1;
      }
    }
    System.out.printf("average is %f%n", (float)sum/10);
    System.out.printf("sum is %d%n", sum);
  }
}
