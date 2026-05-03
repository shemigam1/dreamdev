package week5;

public class ProdOfArrayExceptSelf {

    public static int[] calcArr(int[] array){
        int[] results = new int[array.length];

        int prod = 1;
        for (int k : array) {
            if (k == 0) throw new RuntimeException("cannot divide by zero");
            prod *= k;
        }
        for (int j = 0; j < array.length; j++){
            results[j] = prod / array[j];
        }
        return results;
    }

}
