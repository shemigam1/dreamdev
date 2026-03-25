package week2.day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day1.NumberToWords;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWordTest {
    @Test
    @DisplayName("Take 1 return one")
    public void ConverterOne(){
        String convertedString = NumberToWords.converter(1);
        assertEquals("one", convertedString);
    }

    @Test
    @DisplayName("Take 0 return zero")
    public void ConverterZero(){
        String convertedString = NumberToWords.converter(0);
        assertEquals("zero", convertedString);
    }

    @Test
    @DisplayName("Take 11 return eleven")
    public void ConverterEleven(){
        String convertedString = NumberToWords.converter(11);
        assertEquals("eleven", convertedString);
    }

    @Test
    @DisplayName("Take 19 return nineteen")
    public void ConverterNineteen(){
        String convertedString = NumberToWords.converter(19);
        assertEquals("nineteen", convertedString);
    }

    @Test
    @DisplayName("Take 20 return twenty")
    public void ConverterTwenty(){
        String convertedString = NumberToWords.converter(20);
        assertEquals("twenty", convertedString);
    }

    @Test
    @DisplayName("Take 21 return twenty one")
    public void ConverterTwentyOne(){
        String convertedString = NumberToWords.converter(21);
        assertEquals("twenty one", convertedString);
    }

    @Test
    @DisplayName("Take 99 return ninety nine")
    public void ConverterNinetyNine(){
        String convertedString = NumberToWords.converter(99);
        assertEquals("ninety nine", convertedString);
    }

    @Test
    @DisplayName("Take 100 return one hundred")
    public void ConverterOneHundred(){
        String convertedString = NumberToWords.converter(100);
        assertEquals("one hundred", convertedString);
    }

    @Test
    @DisplayName("Take 115 return one hundred fifteen")
    public void ConverterOneHundredFifteen(){
        String convertedString = NumberToWords.converter(115);
        assertEquals("one hundred fifteen", convertedString);
    }

    @Test
    @DisplayName("Take 999 return nine hundred ninety nine")
    public void ConverterNineHundredNinetyNine(){
        String convertedString = NumberToWords.converter(999);
        assertEquals("nine hundred ninety nine", convertedString);
    }

    @Test
    @DisplayName("Take 1000 return one thousand")
    public void ConverterOneThousand(){
        String convertedString = NumberToWords.converter(1000);
        assertEquals("one thousand", convertedString);
    }

    @Test
    @DisplayName("Take 1234 return one thousand two hundred thirty four")
    public void ConverterOneThousandTwoHundredThirtyFour(){
        String convertedString = NumberToWords.converter(1234);
        assertEquals("one thousand two hundred thirty four", convertedString);
    }

    @Test
    @DisplayName("Take 1000000 return one million")
    public void ConverterOneMillion(){
        String convertedString = NumberToWords.converter(1000000);
        assertEquals("one million", convertedString);
    }

    @Test
    @DisplayName("Take negative -1 return negative one")
    public void ConverterNegativeOne(){
        String convertedString = NumberToWords.converter(-1);
        assertEquals("negative one", convertedString);
    }
}
