package week2.day1.assignment;

import java.util.ArrayList;

public class ProblemHandler {
    ArrayList<Problem> problems = new ArrayList<>();

    public void addProblem(Problem problem){
        problems.add(problem);
    }

    public void solveProblem(Problem problem){
        problems.remove(problem);
    }

    public void tellProblems(Problem problem){
        System.out.println(problems);
    }
}
