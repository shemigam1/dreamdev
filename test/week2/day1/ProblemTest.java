package week2.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day1.assignment.Problem;
import week2.day1.assignment.ProblemHandler;
import week2.day1.assignment.ProblemType;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    ProblemHandler handler;
    Problem financialProblem;
    Problem technicalProblem;

    @BeforeEach
    public void setUp(){
        handler = new ProblemHandler();
        financialProblem = new Problem("Sporty bet", "financial");
        technicalProblem = new Problem("I never finish assignment", "technical");
    }

    @Test
    @DisplayName("Add problem, expect size 1")
    public void addProblem(){
        handler.addProblem(financialProblem);
        assertEquals(1, handler.problems.size());
    }

    @Test
    @DisplayName("Add two problems, expect size 2")
    public void addTwoProblems(){
        handler.addProblem(financialProblem);
        handler.addProblem(technicalProblem);
        assertEquals(2, handler.problems.size());
    }

    @Test
    @DisplayName("Add then solve problem, expect size 0")
    public void solveProblem(){
        handler.addProblem(financialProblem);
        handler.solveProblem(financialProblem);
        assertEquals(0, handler.problems.size());
    }

    @Test
    @DisplayName("Solve problem not in list, expect size unchanged")
    public void solveNonExistentProblem(){
        handler.addProblem(financialProblem);
        handler.solveProblem(technicalProblem);
        assertEquals(1, handler.problems.size());
    }

    @Test
    @DisplayName("Add problem, check type is FINANCIAL")
    public void checkProblemType(){
        handler.addProblem(financialProblem);
        assertEquals(ProblemType.FINANCIAL, handler.problems.get(0).type);
    }

    @Test
    @DisplayName("Invalid problem type, expect exception")
    public void invalidProblemType(){
        assertThrows(IllegalArgumentException.class, () -> new Problem("test", "invalid"));
    }
}