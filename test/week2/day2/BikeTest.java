package week2.day2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day2.assignment.Bike;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTest {
    @Test
    @DisplayName("Bike test on")
    public void biketestOnWhenOff(){
        Bike bike = new Bike();
        assertEquals("off", bike.power);
        bike.turnOn();
        assertEquals("on", bike.power);
    }

    public void biketestOffWhenOn(){
        Bike bike = new Bike();
        assertEquals("on", bike.power);
        bike.turnOff();
        assertEquals("off", bike.power);
    }
}
