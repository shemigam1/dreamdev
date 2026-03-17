import java.util.Scanner;
import java.lang.Math;

public class BMI{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your weight (kg)");
    int weight = input.nextInt();
    System.out.println("Input your height (cm)");
    int height = input.nextInt();
    double bmi = weight/(Math.pow((double)height/100, 2));

    System.out.printf("your BMI is %f%n", bmi);
  }
}
