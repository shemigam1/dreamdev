package week2.day1.assignment;

public enum ProblemType {
    FINANCIAL("financial"),
    SPIRITUAL("spiritual"),
    EDUCATIONAL("educational"),
    BUSINESS("business"),
    TECHNICAL("technical");

    private final String type;

    ProblemType(String type){
        this.type = type;
    }

    public String getType() {return this.type;}
}
