package week2.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day2.assignment.AC;

import static org.junit.jupiter.api.Assertions.*;

public class ACTest {

    AC ac;

    @BeforeEach
    public void setUp(){
        ac = new AC();
    }

    @Test
    @DisplayName("AC turns on")
    public void acTestTurnOn(){
        ac.turnOn();
        assertEquals("on", ac.power);
    }

    @Test
    @DisplayName("AC turns off")
    public void acTestTurnOff(){
        ac.turnOn();
        ac.turnOff();
        assertEquals("off", ac.power);
    }

    @Test
    @DisplayName("AC increases temp when on")
    public void acTestIncreaseTempWhenOn(){
        ac.turnOn();
        assertEquals("on", ac.power);
        ac.increaseTemp(2);
        assertEquals(18, ac.temperature);
    }

    @Test
    @DisplayName("AC increases temp multiple times")
    public void acTestIncreaseTempMultiple(){
        ac.turnOn();
        assertEquals("on", ac.power);
        ac.increaseTemp(2);
        assertEquals(18, ac.temperature);

        ac.increaseTemp(2);
        assertEquals(20, ac.temperature);
    }

    @Test
    @DisplayName("AC does not increase temp when off")
    public void acTestIncreaseTempWhenOff(){
        assertEquals("off", ac.power);
        ac.increaseTemp(2);
        assertEquals(16, ac.temperature);
    }

    @Test
    @DisplayName("AC does not go higher than 30")
    public void acTestIncreaseTempLimit(){
        ac.turnOn();
        ac.increaseTemp(20);
        assertEquals(30, ac.temperature);
    }

    @Test
    @DisplayName("AC decreases temp when on")
    public void acTestDecreaseTempWhenOn(){
        ac.turnOn();
        ac.increaseTemp(4);
        assertEquals(20, ac.temperature);

        ac.decreaseTemp(2);
        assertEquals(18, ac.temperature);
    }

    @Test
    @DisplayName("AC decreases temp multiple times")
    public void acTestDecreaseTempMultiple(){
        ac.turnOn();
        ac.increaseTemp(6);
        assertEquals(22, ac.temperature);

        ac.decreaseTemp(2);
        assertEquals(20, ac.temperature);

        ac.decreaseTemp(2);
        assertEquals(18, ac.temperature);
    }

    @Test
    @DisplayName("AC does not decrease temp when off")
    public void acTestDecreaseTempWhenOff(){
        assertEquals("off", ac.power);
        ac.decreaseTemp(2);
        assertEquals(16, ac.temperature);
    }

    @Test
    @DisplayName("AC does not go below 16")
    public void acTestDecreaseTempFloor(){
        ac.turnOn();
        ac.decreaseTemp(10);
        assertEquals(16, ac.temperature);
    }

    @Test
    @DisplayName("AC decreases to min temp")
    public void acTestDecreaseTempToMin(){
        ac.turnOn();
        ac.increaseTemp(2);
        assertEquals(18, ac.temperature);

        ac.decreaseTemp(2);
        assertEquals(16, ac.temperature);
    }
}