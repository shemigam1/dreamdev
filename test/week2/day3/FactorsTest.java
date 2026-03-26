package week2.day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorsTest {
    Factors factors;
    @Test
    @DisplayName("Test 10, should return 1,2,5,10")
    public void testTen(){
        ArrayList<Integer> factors = new ArrayList<>(Arrays.asList(1,2,5,10));
        assertEquals(factors, Factors.getFactors(10));
    }

    @Test
    @DisplayName("Test 20, should return 1,2,5,10, 20")
    public void testTwenty(){
        ArrayList<Integer> factors = new ArrayList<>(Arrays.asList(1,2,4, 5,10, 20));
        assertEquals(factors, Factors.getFactors(20));
    }
}
