package week4.day2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SquareAndSortTest {
    @Test
    public void squareAndSortArray(){
        int[] numbers = {44, 5, 8, 33, 90};
        int[] squared = SquareAndSort.square(numbers);
        int [] sorted = SquareAndSort.sort(squared);
        System.out.println(Arrays.toString(sorted));
    }

}