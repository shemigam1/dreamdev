import java.util.Scanner;
import java.lang.Math;

public class Arithmetic{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Input your radius");
    float rad = input.nextFloat();

    System.out.printf("%f is the diameter of circle r = %f%n", 2*rad, rad);
    System.out.printf("%f is the circumference of circle r = %f%n", 2*Math.PI*rad, rad);

    System.out.printf("%f is the area of circle r = %f%n", Math.PI*Math.pow(rad, 2), rad);
  }
}
