package week1.day1;

import java.lang.Math;

public class PopulationGrowth{
  public static void main(String[] args){
    System.out.println("Doomsday clock, when we reach 666666666, the world will end");
    long current = 8281776510L;
    for (int i = 0; i <= 5; i++){
      System.out.printf("in %d years, %d%n", i, (long) (current * Math.pow(Math.E, 0.84*i)));
    }
  }
}
