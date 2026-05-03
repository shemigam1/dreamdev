package week4.day2;

public class DivideAndConquer {
    public static boolean validate (int divisor, int number){
//        if (divisor < 0 && number < 0) return true;
        if (divisor <= 0) return false;
        if (number == 0) return false;
        return true;
    }

    public static int divide(int number, int divisor){
        if (!validate(divisor, number)) return 0;
        boolean negative = false;
        if (number < 0) {
            number = -(number);
            negative = true;
        }
//        if (divisor < 0) {
//            divisor = -divisor;
//            negative = false;
//        }
        if (divisor >= number) return 1;

        int comp = 0;
        int rounds = 0;
        while ((comp + divisor) <= number){
            comp +=  divisor;
            rounds += 1;
        }
        if (negative) return -rounds;
        return rounds;
    }
}
