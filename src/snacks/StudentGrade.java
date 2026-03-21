package snacks;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students do you have?");
        int totalStudents = scanner.nextInt();

        System.out.println("How many subject do they offer");
        int totalSubjects = scanner.nextInt();

        int[][] classRoom = new int[totalStudents][totalSubjects];

    }
}
