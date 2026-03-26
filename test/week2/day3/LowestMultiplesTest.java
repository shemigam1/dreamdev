package week2.day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestMultiplesTest {


//    @Test
//    @DisplayName("Test 10, should return 1,2,5,10")
//    public void testTen(){
//        ArrayList<Integer> factors = new ArrayList<>(Arrays.asList(1,2,5,10));
//        assertEquals(factors, Factors.getFactors(10));
//    }

    @Test
    @DisplayName("Test 20, should return [2,2,5]")
    public void testTwenty(){
        ArrayList<Integer> factors = new ArrayList<>(Arrays.asList(2,3,5));
        assertEquals(factors, LowestMultiples.getLowestMultiples(30));
    }
}
