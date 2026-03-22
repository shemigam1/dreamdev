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
    @DisplayName("Test -4, 2, expect 6")
    public void subtractNegativePositive(){
        assertEquals(6, Kata.subtract(-4, 2));
    }

    @Test
    @DisplayName("Test -4, -2, expect -2")
    public void subtractNegative(){
        assertEquals(2, Kata.subtract(-4, -2));
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

    @Test
    @DisplayName("Test 6, expect 4 factors")
    public void factorOfSix(){
        assertEquals(4, Kata.factorOf(6));
    }

    @Test
    @DisplayName("Test 1, expect 1 factor")
    public void factorOfOne(){
        assertEquals(1, Kata.factorOf(1));
    }

    @Test
    @DisplayName("Test prime 7, expect 2 factors")
    public void factorOfPrime(){
        assertEquals(2, Kata.factorOf(7));
    }

    @Test
    @DisplayName("Test 9, expect true")
    public void isSquareCheckSquare(){
        assertTrue(Kata.isSquare(9));
    }

    @Test
    @DisplayName("Test 10, expect false")
    public void isSquareCheckNonSquare(){
        assertFalse(Kata.isSquare(10));
    }

    @Test
    @DisplayName("Test 0, expect false")
    public void isSquareCheckZero(){
        assertFalse(Kata.isSquare(0));
    }

    @Test
    @DisplayName("Test 121, expect true")
    public void isPalindromeCheckPalindrome(){
        assertTrue(Kata.isPalindrome(121));
    }

    @Test
    @DisplayName("Test 123, expect false")
    public void isPalindromeCheckNonPalindrome(){
        assertFalse(Kata.isPalindrome(123));
    }

    @Test
    @DisplayName("Test single digit 5, expect true")
    public void isPalindromeCheckSingleDigit(){
        assertTrue(Kata.isPalindrome(5));
    }

    @Test
    @DisplayName("Test 5, expect 120")
    public void factorialOfFive(){
        assertEquals(120, Kata.factorial(5));
    }

    @Test
    @DisplayName("Test 0, expect 1")
    public void factorialOfZero(){
        assertEquals(1, Kata.factorial(0));
    }

    @Test
    @DisplayName("Test 1, expect 1")
    public void factorialOfOne(){
        assertEquals(1, Kata.factorial(1));
    }

    @Test
    @DisplayName("Test 4, expect 16")
    public void squareOfFour(){
        assertEquals(16, Kata.squareOf(4));
    }

    @Test
    @DisplayName("Test 0, expect 0")
    public void squareOfZero(){
        assertEquals(0, Kata.squareOf(0));
    }

    @Test
    @DisplayName("Test negative -3, expect 9")
    public void squareOfNegative(){
        assertEquals(9, Kata.squareOf(-3));
    }
}
