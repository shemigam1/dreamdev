package week2.day1.assignment;

import java.util.ArrayList;

public class Problem {
    public String name;
    public ProblemType type;

    public Problem(String name, String type){
        this.name = name;
        this.type = ProblemType.valueOf(type.toUpperCase());
    }
}
