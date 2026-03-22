package snacks.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentGradeTest {
    int[][] classRoom = {
            {90, 40, 80},
            {60, 70, 50},
            {30, 85, 95}
    };

    @Test
    @DisplayName("Highest scoring student in subject, expect student 1 with 90")
    public void highestScoringStudentBasic(){
        assertArrayEquals(new int[]{1, 90}, StudentGrade.highestScoringStudent(new int[]{90, 60, 30}));
    }

    @Test
    @DisplayName("Highest scoring student last position, expect student 3 with 95")
    public void highestScoringStudentLast(){
        assertArrayEquals(new int[]{3, 95}, StudentGrade.highestScoringStudent(new int[]{60, 70, 95}));
    }

    @Test
    @DisplayName("Lowest scoring student in subject, expect student 3 with 30")
    public void lowestScoringStudentBasic(){
        assertArrayEquals(new int[]{3, 30}, StudentGrade.lowestScoringStudent(new int[]{90, 60, 30}));
    }

    @Test
    @DisplayName("Lowest scoring student first position, expect student 1 with 30")
    public void lowestScoringStudentFirst(){
        assertArrayEquals(new int[]{1, 30}, StudentGrade.lowestScoringStudent(new int[]{30, 60, 95}));
    }

    @Test
    @DisplayName("Total subject score, expect 180")
    public void totalSubjectScoreBasic(){
        assertEquals(180, StudentGrade.totalSubjectScore(new int[]{90, 60, 30}));
    }

    @Test
    @DisplayName("Total subject score all zeros, expect 0")
    public void totalSubjectScoreZeros(){
        assertEquals(0, StudentGrade.totalSubjectScore(new int[]{0, 0, 0}));
    }

    @Test
    @DisplayName("Average subject score, expect 60.0")
    public void averageSubjectScoreBasic(){
        assertEquals(60.0, StudentGrade.averageSubjectScore(new int[]{90, 60, 30}));
    }

    @Test
    @DisplayName("Average subject score all same, expect 80.0")
    public void averageSubjectScoreAllSame(){
        assertEquals(80.0, StudentGrade.averageSubjectScore(new int[]{80, 80, 80}));
    }

    @Test
    @DisplayName("Total passes, expect 2")
    public void totalPassScoresBasic(){
        assertEquals(2, StudentGrade.totalPassScores(new int[]{90, 45, 80}));
    }

    @Test
    @DisplayName("Total passes none, expect 0")
    public void totalPassScoresNone(){
        assertEquals(0, StudentGrade.totalPassScores(new int[]{70, 60, 50}));
    }

    @Test
    @DisplayName("Total passes boundary 80, expect 1")
    public void totalPassScoresBoundary(){
        assertEquals(1, StudentGrade.totalPassScores(new int[]{80, 79, 50}));
    }

    @Test
    @DisplayName("Total fails, expect 1")
    public void totalFailScoresBasic(){
        assertEquals(1, StudentGrade.totalFailScores(new int[]{90, 45, 80}));
    }

    @Test
    @DisplayName("Total fails none, expect 0")
    public void totalFailScoresNone(){
        assertEquals(0, StudentGrade.totalFailScores(new int[]{90, 80, 70}));
    }

    @Test
    @DisplayName("Total fails boundary 49, expect 1")
    public void totalFailScoresBoundary(){
        assertEquals(1, StudentGrade.totalFailScores(new int[]{49, 50, 90}));
    }

    @Test
    @DisplayName("Easiest subject is subject 3, expect {3, 2}")
    public void easiestSubjectBasic(){
        assertArrayEquals(new int[]{3, 2}, StudentGrade.easiestSubject(classRoom, 3));
    }

    @Test
    @DisplayName("Highest overall score, expect student 3 subject 3 scoring 95")
    public void highestOverallScoreBasic(){
        assertArrayEquals(new int[]{3, 3, 95}, StudentGrade.highestOverallScore(classRoom));
    }

    @Test
    @DisplayName("Lowest overall score, expect student 3 subject 1 scoring 30")
    public void lowestOverallScoreBasic(){
        assertArrayEquals(new int[]{3, 1, 30}, StudentGrade.lowestOverallScore(classRoom));
    }

    @Test
    @DisplayName("Best graduating student clear winner, expect student 1 with 270")
    public void bestGraduatingStudentClearWinner(){
        assertArrayEquals(new int[]{1, 270}, StudentGrade.bestGraduatingStudent(new int[]{270, 180, 150}));
    }

    @Test
    @DisplayName("Worst graduating student, expect student 2 with 150")
    public void worstGraduatingStudentBasic(){
        assertArrayEquals(new int[]{2, 150}, StudentGrade.worstGraduatingStudent(new int[]{270, 150, 210}));
    }

    @Test
    @DisplayName("Class total score, expect 630")
    public void classTotalScoreBasic(){
        assertEquals(630, StudentGrade.classTotalScore(new int[]{270, 180, 180}));
    }

    @Test
    @DisplayName("Class average score, expect 210.0")
    public void classAverageScoreBasic(){
        assertEquals(210.0, StudentGrade.classAverageScore(new int[]{270, 180, 180}));
    }

}
