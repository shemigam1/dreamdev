package snacks.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayKataTest {

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 5")
    public void maximumInBasic(){
        assertEquals(5, ArrayKata.maximumIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test with negatives [-1,-2,-3], expect -1")
    public void maximumInNegatives(){
        assertEquals(-1, ArrayKata.maximumIn(new int[]{-1, -2, -3}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 1")
    public void minimumInBasic(){
        assertEquals(1, ArrayKata.minimumIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test with negatives [-1,-2,-3], expect -3")
    public void minimumInNegatives(){
        assertEquals(-3, ArrayKata.minimumIn(new int[]{-1, -2, -3}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 15")
    public void sumOfBasic(){
        assertEquals(15, ArrayKata.sumOf(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test empty array, expect 0")
    public void sumOfEmpty(){
        assertEquals(0, ArrayKata.sumOf(new int[]{}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 6")
    public void sumOfEvenNumbersBasic(){
        assertEquals(6, ArrayKata.sumOfEvenNumbersIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test all odd [1,3,5], expect 0")
    public void sumOfEvenNumbersNoEvens(){
        assertEquals(0, ArrayKata.sumOfEvenNumbersIn(new int[]{1, 3, 5}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 9")
    public void sumOfOddNumbersBasic(){
        assertEquals(9, ArrayKata.sumOfOddNumbersIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test all even [2,4,6], expect 0")
    public void sumOfOddNumbersNoOdds(){
        assertEquals(0, ArrayKata.sumOfOddNumbersIn(new int[]{2, 4, 6}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect {1,5}")
    public void maximumAndMinimumOfBasic(){
        assertArrayEquals(new int[]{1, 5}, ArrayKata.maximumAndMinimumOf(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test [5], expect {5,5}")
    public void maximumAndMinimumOfSingleElement(){
        assertArrayEquals(new int[]{5, 5}, ArrayKata.maximumAndMinimumOf(new int[]{5}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 3")
    public void noOfOddNumbersBasic(){
        assertEquals(3, ArrayKata.noOfOddNumbersIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test all even [2,4,6], expect 0")
    public void noOfOddNumbersNoOdds(){
        assertEquals(0, ArrayKata.noOfOddNumbersIn(new int[]{2, 4, 6}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect 2")
    public void noOfEvenNumbersBasic(){
        assertEquals(2, ArrayKata.noOfEvenNumbersIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test all odd [1,3,5], expect 0")
    public void noOfEvenNumbersNoEvens(){
        assertEquals(0, ArrayKata.noOfEvenNumbersIn(new int[]{1, 3, 5}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect [2,4]")
    public void evenNumbersInBasic(){
        assertEquals(new ArrayList<>(Arrays.asList(2, 4)), ArrayKata.evenNumbersIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test all odd [1,3,5], expect empty list")
    public void evenNumbersInNoEvens(){
        assertEquals(new ArrayList<>(), ArrayKata.evenNumbersIn(new int[]{1, 3, 5}));
    }

    @Test
    @DisplayName("Test [1,2,3,4,5], expect [1,3,5]")
    public void oddNumbersInBasic(){
        assertEquals(new ArrayList<>(Arrays.asList(1, 3, 5)), ArrayKata.oddNumbersIn(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test all even [2,4,6], expect empty list")
    public void oddNumbersInNoOdds(){
        assertEquals(new ArrayList<>(), ArrayKata.oddNumbersIn(new int[]{2, 4, 6}));
    }

    @Test
    @DisplayName("Test [1,2,3], expect [1,4,9]")
    public void squareNumbersInBasic(){
        assertEquals(new ArrayList<>(Arrays.asList(1, 4, 9)), ArrayKata.squareNumbersIn(new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("Test with negative [-2,3], expect [4,9]")
    public void squareNumbersInNegative(){
        assertEquals(new ArrayList<>(Arrays.asList(4, 9)), ArrayKata.squareNumbersIn(new int[]{-2, 3}));
    }
}