package week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
