package week2.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day2.assignment.Bike;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeTest {
    private Bike bike;

    @BeforeEach
    public void setup(){
        bike = new Bike();
    }

    @Test
    @DisplayName("Bike test on when off")
    public void bikeTestOnWhenOff(){

        assertEquals("off", bike.power);
        bike.turnOn();
        assertEquals("on", bike.power);
    }

    @Test
    @DisplayName("Bike test off when on")
    public void bikeTestOffWhenOn(){
        bike.turnOn();
        assertEquals("on", bike.power);
        bike.turnOff();
        assertEquals("off", bike.power);
    }

    @Test
    @DisplayName("Bike accelerates when on")
    public void bikeTestAccelerateWhenOn(){
        bike.turnOn();
        assertEquals("on", bike.power);
        bike.accelerate(2);
        assertEquals(2, bike.speed);
    }

    @Test
    @DisplayName("Bike accelerates when on to gear 2")
    public void bikeTestAccelerateGear2(){
        bike.turnOn();
        assertEquals("on", bike.power);
        bike.accelerate(25);
        assertEquals(25, bike.speed);

        bike.accelerate(2);
        assertEquals(29, bike.speed);
    }

    @Test
    @DisplayName("Bike accelerates when on to gear 3")
    public void bikeTestAccelerateGear3(){
        bike.turnOn();
        assertEquals("on", bike.power);
        bike.accelerate(32);
        assertEquals(32, bike.speed);

        bike.accelerate(2);
        assertEquals(38, bike.speed);
    }

    @Test
    @DisplayName("Bike accelerates when on from gear 2 to gear 3")
    public void bikeTestAccelerateSwitchGears(){
        bike.turnOn();
        assertEquals("on", bike.power);
        bike.accelerate(38);
        assertEquals(38, bike.speed);

        bike.accelerate(2);
        assertEquals(38+3+3, bike.speed);

        bike.accelerate(2);
        assertEquals(38+3+3+4+4, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerates when on")
    public void bikeTestDecelerateWhenOn(){
        bike.turnOn();
        bike.accelerate(10);
        assertEquals(10, bike.speed);

        bike.decelerate(2);
        assertEquals(8, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerates from gear 2")
    public void bikeTestDecelerateGear2(){
        bike.turnOn();
        bike.accelerate(25);
        assertEquals(25, bike.speed);

        bike.decelerate(2);
        assertEquals(21, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerates from gear 3")
    public void bikeTestDecelerateGear3(){
        bike.turnOn();
        bike.accelerate(32);
        assertEquals(32, bike.speed);

        bike.decelerate(2);
        assertEquals(26, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerates from gear 4")
    public void bikeTestDecelerateGear4(){
        bike.turnOn();
        bike.accelerate(45);
        assertEquals(45, bike.speed);

        bike.decelerate(2);
        assertEquals(37, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerates switching gears")
    public void bikeTestDecelerateSwitchGears(){
        bike.turnOn();
        bike.accelerate(45);
        assertEquals(45, bike.speed);

        bike.decelerate(2);
        assertEquals(45-4-4, bike.speed);

        bike.decelerate(2);
        assertEquals(45-4-4-3-3, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerates to 0, expect 0 not negative")
    public void bikeTestDecelerateFloor(){
        bike.turnOn();
        bike.accelerate(2);
        assertEquals(2, bike.speed);

        bike.decelerate(10);
        assertEquals(0, bike.speed);
    }

    @Test
    @DisplayName("Bike decelerate when not moving, no change")
    public void bikeTestDecelerateWhenStopped(){
        bike.turnOn();
        assertEquals(0, bike.speed);

        bike.decelerate(2);
        assertEquals(0, bike.speed);
    }
}
