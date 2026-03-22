package snacks.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
}
