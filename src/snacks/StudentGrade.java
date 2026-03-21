package snacks;

import java.util.Arrays;
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
                System.out.printf("Entering score for student %d%n", i + 1);
                System.out.printf("Entering score for subject %d%n", j + 1);
                int score = scanner.nextInt();
                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Saved successfully");
                classRoom[i][j] = score;
            }
        }

        String reportCard = """
                ============================================
                """;
        String header = "STUDENT    ";
        for (int i = 0; i < totalSubjects; i++){
            header += String.format("%-7s", "SUB" +( i+1));
        }
        header += String.format("%-5s %-5s %-7s%n", "TOT", "AVE", "POS");

        reportCard += header;

        System.out.println(reportCard);
    }
}
