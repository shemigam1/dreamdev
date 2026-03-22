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
        body += "\n";

        int[] hardest = hardestSubject(classRoom, totalSubjects);
        int[] easiest = easiestSubject(classRoom, totalSubjects);
        int[] highestOverall = highestOverallScore(classRoom);
        int[] lowestOverall = lowestOverallScore(classRoom);
        int[] best = bestGraduatingStudent(totalScores);
        int[] worst = worstGraduatingStudent(totalScores);

        String subjectSummary = String.format("""
        The hardest subject is Subject %d with %d failures
        The easiest subject is Subject %d with %d passes
        The overall highest score is scored by Student %d in Subject %d scoring %d
        The overall lowest score is scored by Student %d in Subject %d scoring %d
        The best graduating student is Student %d with a total score of %d
        The worst graduating student is Student %d with a total score of %d
        ===============================================================
        """,
                hardest[0], hardest[1],
                easiest[0], easiest[1],
                highestOverall[0], highestOverall[1], highestOverall[2],
                lowestOverall[0], lowestOverall[1], lowestOverall[2],
                best[0], best[1],
                worst[0], worst[1]);

        body += subjectSummary;

        String classSummary = String.format("""
        CLASS SUMMARY
        ===============================================================
        Best Graduating student is: Student %d scoring %d
        ===============================================================
        
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Worst Graduating student is: Student %d scoring %d
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        ===============================================================
        Class total score is: %d
        Class Average score is: %.2f
        ===============================================================
        """,
                best[0], best[1],
                worst[0], worst[1],
                classTotalScore(totalScores),
                classAverageScore(totalScores));
        body += classSummary;
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

    public static int[] hardestSubject(int[][] classRoom, int totalSubjects){
        int hardestIdx = 0;
        int mostFails = 0;

        for (int j = 0; j < totalSubjects; j++){
            int[] subjectColumn = new int[classRoom.length];
            for (int i = 0; i < classRoom.length; i++){
                subjectColumn[i] = classRoom[i][j];
            }
            int fails = totalFailScores(subjectColumn);
            if (fails > mostFails){
                mostFails = fails;
                hardestIdx = j;
            }
        }
        return new int[]{hardestIdx + 1, mostFails};
    }

    public static int[] easiestSubject(int[][] classRoom, int totalSubjects){
        int easiestIdx = 0;
        int mostPasses = 0;

        for (int j = 0; j < totalSubjects; j++){
            int[] subjectColumn = new int[classRoom.length];
            for (int i = 0; i < classRoom.length; i++){
                subjectColumn[i] = classRoom[i][j];
            }
            int passes = totalPassScores(subjectColumn);
            if (passes > mostPasses){
                mostPasses = passes;
                easiestIdx = j;
            }
        }
        return new int[]{easiestIdx + 1, mostPasses};
    }

    public static int[] highestOverallScore(int[][] classRoom){
        int studentIdx = 0;
        int subjectIdx = 0;
        int highestScore = 0;

        for (int i = 0; i < classRoom.length; i++){
            for (int j = 0; j < classRoom[i].length; j++){
                if (classRoom[i][j] > highestScore){
                    highestScore = classRoom[i][j];
                    studentIdx = i;
                    subjectIdx = j;
                }
            }
        }
        return new int[]{studentIdx + 1, subjectIdx + 1, highestScore};
    }

    public static int[] lowestOverallScore(int[][] classRoom){
        int studentIdx = 0;
        int subjectIdx = 0;
        int lowestScore = Integer.MAX_VALUE;

        for (int i = 0; i < classRoom.length; i++){
            for (int j = 0; j < classRoom[i].length; j++){
                if (classRoom[i][j] < lowestScore){
                    lowestScore = classRoom[i][j];
                    studentIdx = i;
                    subjectIdx = j;
                }
            }
        }
        return new int[]{studentIdx + 1, subjectIdx + 1, lowestScore};
    }

    public static int[] bestGraduatingStudent(int[] totalScores){
        int studentIdx = 0;
        int highestTotal = 0;

        for (int i = 0; i < totalScores.length; i++){
            if (totalScores[i] > highestTotal){
                highestTotal = totalScores[i];
                studentIdx = i;
            }
        }
        return new int[]{studentIdx + 1, highestTotal};
    }

    public static int[] worstGraduatingStudent(int[] totalScores){
        int studentIdx = 0;
        int lowestTotal = Integer.MAX_VALUE;

        for (int i = 0; i < totalScores.length; i++){
            if (totalScores[i] < lowestTotal){
                lowestTotal = totalScores[i];
                studentIdx = i;
            }
        }
        return new int[]{studentIdx + 1, lowestTotal};
    }

    public static int classTotalScore(int[] totalScores){
        int total = 0;
        for (int score: totalScores){
            total += score;
        }
        return total;
    }

    public static double classAverageScore(int[] totalScores){
        int total = 0;
        for (int score: totalScores){
            total += score;
        }
        return (double) total / totalScores.length;
    }


}
