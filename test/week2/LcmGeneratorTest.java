package week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day2.LcmGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcmGeneratorTest {
    @Test
    @DisplayName("Take 50, 20, 30 return 300")
    public void LCMThreeNumbers(){
        int[] numbers = {50, 30, 20};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(300, lcm);
    }

    @Test
    @DisplayName("Take 50, 20, 30, 40 return 600")
    public void LCMFourNumbers(){
        int[] numbers = {50, 30, 20, 40};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(600, lcm);
    }

    @Test
    @DisplayName("Take 50, 20, 30, 0 return 0")
    public void LCMFourNumbersWithZero(){
        int[] numbers = {50, 30, 20, 0};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(0, lcm);
    }

    @Test
    @DisplayName("Take 50, 20, 30, -40 return 600")
    public void LCMFourNumbersWithNegative(){
        int[] numbers = {50, 30, 20, -40};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(600, lcm);
    }

    @Test
    @DisplayName("Take 1,1,1,1 return 1")
    public void LCMOnes(){
        int[] numbers = {1,1,1,1};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(1, lcm);
    }

    @Test
    @DisplayName("Take 1,1,1,6 return 6")
    public void LCMOnesWithSix(){
        int[] numbers = {1,1,1,6};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(6, lcm);
    }

    @Test
    @DisplayName("Take 0,0,0,0 return 0")
    public void LCMZeroes(){
        int[] numbers = {0,0,0,0};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(0, lcm);
    }

    @Test
    @DisplayName("Take -40, -30, -20, -50, return 600")
    public void LCMNegativeNumbers(){
        int[] numbers = {-40, -30, -20, -50};
        int lcm = LcmGenerator.LCM(numbers);
        assertEquals(600, lcm);
    }
}
