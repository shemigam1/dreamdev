package week1.day1;

import java.util.Arrays;


public class Demo{
    public static void main(String[] args){
        int[] scores= {22, 44, 3, 2, 55};
        for (int score:scores){
            System.out.println(score);
        }
        Arrays.stream(scores).forEach(System.out::println);
        Arrays.stream(scores).forEach( score -> System.out.println());
    }
}