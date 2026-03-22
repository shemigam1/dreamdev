package snacks.week1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KataTest {
    @Test
    @DisplayName("Test even number, expect true")
    public void isEvenCheckEven(){
        assertTrue(Kata.isEven(4));
    }

    @Test
    @DisplayName("Test odd number, expect false")
    public void isEvenCheckOdd(){
        assertFalse(Kata.isEven(3));
    }

    @Test
    @DisplayName("Test prime number, expect true")
    public void isPrimeCheckPrime(){
        assertTrue(Kata.isPrimeNumber(4));
    }

    @Test
    @DisplayName("Test prime number, expect false")
    public void isPrimeCheckNonPrime(){
        assertFalse(Kata.isPrimeNumber(6));
    }

    @Test
    @DisplayName("Test num < 2, expect false")
    public void isPrimeCheckLessThanTwo(){
        assertFalse(Kata.isPrimeNumber(1));
    }

    @Test
    @DisplayName("Test 4, 2, expect 2")
    public void subtractPositive(){
        assertEquals(2, Kata.subtract(4, 2));
    }

    @Test
    @DisplayName("Test 4, -2, expect 6")
    public void subtractPositiveNegative(){
        assertEquals(6, Kata.subtract(4, -2));
    }

    @Test
    @DisplayName("Test -4, 2, expect -6")
    public void subtractNegativePositive(){
        assertEquals(-6, Kata.subtract(-4, 2));
    }

    @Test
    @DisplayName("Test -4, -2, expect -2")
    public void subtractNegative(){
        assertEquals(-2, Kata.subtract(-4, -2));
    }

    @Test
    @DisplayName("Test 3,0, expect 0")
    public void divideByZero(){
        assertEquals(0, Kata.divide(3, 0));
    }

    @Test
    @DisplayName("Test 3,2, expect 1.5")
    public void divideByInt(){
        assertEquals(1.5, Kata.divide(3, 2));
    }
}
