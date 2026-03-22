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

        int[] totalScores = new int[totalStudents];
        int[] positions = new int[totalStudents];
        for (int i = 0; i < totalStudents; i++){
            int totalScore = 0;
            for (int j = 0; j < totalSubjects; j++){
                totalScore += classRoom[i][j];
            }
            totalScores[i] = totalScore;
        }

        for (int i = 0; i < totalStudents; i++) {
            int rank = 1;
            for (int j = 0; j < totalScores.length; j++) {
                if (totalScores[j] > totalScores[i]) rank++;
            }
            positions[i] = rank;
        }

        String reportCard = """
                ============================================
                """;
        String header = "STUDENT    ";
        for (int i = 0; i < totalSubjects; i++){
            header += String.format("%-7s", "SUB" +( i+1));
        }
        header += String.format("%-5s %-7s %7s%n", "TOT", "AVE", "POS");

        reportCard += header;
        reportCard += "============================================";

        System.out.println(reportCard);

        String body = "";
        for (int i = 0; i < totalStudents; i++){
            String row = "";
            row += String.format("Student %d", i + 1);
//            int totalScore = 0;
            for (int j = 0; j < totalSubjects; j++){
                row += String.format("%5s", classRoom[i][j]);
//                totalScore += classRoom[i][j];
            }
            row += String.format("%6d", totalScores[i]);
            double averageScore = (double) totalScores[i]/totalSubjects;
            row += String.format("%8.2f", averageScore);
            row += String.format("%7d%n", positions[i]);
            body += row;
        }
//        System.out.println(body);

        body += "============================================";
        body += "============================================\n";

        for (int j = 0; j < totalSubjects; j++) {
            int[] subjectColumn = new int[totalStudents];
            for (int i = 0; i < totalStudents; i++) {
                subjectColumn[i] = classRoom[i][j];
            }

            int[] highest = highestScoringStudent(subjectColumn);
            int[] lowest = lowestScoringStudent(subjectColumn);
            int total = totalSubjectScore(subjectColumn);
            double average = averageSubjectScore(subjectColumn);
            int passes = totalPassScores(subjectColumn);
            int fails = totalFailScores(subjectColumn);

            String scoreSummary = String.format("""
            SUBJECT %d SUMMARY
            Highest Score: Student %d with %d
            Lowest Score:  Student %d with %d
            Total Score:   %d
            Average Score: %.2f
            Total Passes:  %d
            Total Fails:   %d
            """, j + 1, highest[0], highest[1], lowest[0], lowest[1], total, average, passes, fails);

            body += scoreSummary;
//            System.out.println(scoreSummary);
        }

        System.out.println(body);
    }

    public static int[] highestScoringStudent(int[] subjectColumn){
        int idx = 0;
        for (int i = 1; i < subjectColumn.length; i++){
            if(subjectColumn[i] > subjectColumn[idx]) idx = i;
        }
        return new int[] {idx+1, subjectColumn[idx]};
    }

    public static int[] lowestScoringStudent(int[] subjectColumn){
        int idx = 0;
        for (int i = 1; i < subjectColumn.length; i++){
            if(subjectColumn[i] < subjectColumn[idx]) idx = i;
        }
        return new int[] {idx+1, subjectColumn[idx]};
    }

    public static int totalSubjectScore(int[] subjectColumn){
        int total = 0;
        for (int j : subjectColumn) {
            total += j;
        }
        return total;
    }

    public static double averageSubjectScore(int[] subjectColumn){
        int total = 0;
        for (int j : subjectColumn) {
            total += j;
        }
        return (double) total / subjectColumn.length;
    }

    public static int totalPassScores(int[] subjectColumn){
        int total = 0;
        for (int j : subjectColumn) {
            if (j >= 80) total += 1;
        }
        return total;
    }

    public static int totalFailScores(int[] subjectColumn){
        int total = 0;
        for (int j : subjectColumn) {
            if (j < 50) total += 1;
        }
        return total;
    }
}
