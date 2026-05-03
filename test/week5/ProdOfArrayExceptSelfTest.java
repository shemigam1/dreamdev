package week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdOfArrayExceptSelfTest {

    @Test
    void calcArr() {
        int[] testArr = {2, 1, 5, 6};
        int[] output = {30, 60, 12, 10};

        assertArrayEquals( output, ProdOfArrayExceptSelf.calcArr(testArr));
    }
    @Test
    void calcInvalidArr() {
        int[] testArr = {2, 1, 5, 0};

        assertThrows( RuntimeException.class, ()-> ProdOfArrayExceptSelf.calcArr(testArr));
    }
}