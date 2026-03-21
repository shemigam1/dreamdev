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
        for (int i = 0; i < totalStudents; i++){
            for (int j = 0; j < totalSubjects; j++){
                System.out.printf("Entering score for student %d%n", i);
                System.out.printf("Entering score for subject %d%n", j);
                int score = scanner.nextInt();
                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Saved successfully");
                classRoom[i][j] = score;
            }
        }

        System.out.println(classRoom);
    }
}
