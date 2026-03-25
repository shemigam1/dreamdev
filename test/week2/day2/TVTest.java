package week2.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day2.assignment.TV;

import static org.junit.jupiter.api.Assertions.*;

public class TVTest {

    TV tv;

    @BeforeEach
    public void setUp(){
        tv = new TV();
    }

    @Test
    @DisplayName("TV turns on")
    public void tvTestTurnOn(){
        tv.turnOn();
        assertEquals("on", tv.power);
    }

    @Test
    @DisplayName("TV turns off")
    public void tvTestTurnOff(){
        tv.turnOn();
        tv.turnOff();
        assertEquals("off", tv.power);
    }

    @Test
    @DisplayName("TV increases volume when on")
    public void tvTestIncreaseVolumeWhenOn(){
        tv.turnOn();
        assertEquals("on", tv.power);
        tv.increaseVolume(10);
        assertEquals(10, tv.volume);
    }

    @Test
    @DisplayName("TV increases volume multiple times")
    public void tvTestIncreaseVolumeMultiple(){
        tv.turnOn();
        tv.increaseVolume(10);
        assertEquals(10, tv.volume);

        tv.increaseVolume(10);
        assertEquals(20, tv.volume);
    }

    @Test
    @DisplayName("TV does not increase volume when off")
    public void tvTestIncreaseVolumeWhenOff(){
        assertEquals("off", tv.power);
        tv.increaseVolume(10);
        assertEquals(0, tv.volume);
    }

    @Test
    @DisplayName("TV does not exceed max volume of 100")
    public void tvTestIncreaseVolumeLimit(){
        tv.turnOn();
        tv.increaseVolume(200);
        assertEquals(100, tv.volume);
    }

    @Test
    @DisplayName("TV decreases volume when on")
    public void tvTestDecreaseVolumeWhenOn(){
        tv.turnOn();
        tv.increaseVolume(20);
        assertEquals(20, tv.volume);

        tv.decreaseVolume(10);
        assertEquals(10, tv.volume);
    }

    @Test
    @DisplayName("TV does not decrease volume when off")
    public void tvTestDecreaseVolumeWhenOff(){
        assertEquals("off", tv.power);
        tv.decreaseVolume(10);
        assertEquals(0, tv.volume);
    }

    @Test
    @DisplayName("TV does not go below min volume of 0")
    public void tvTestDecreaseVolumeFloor(){
        tv.turnOn();
        tv.decreaseVolume(10);
        assertEquals(0, tv.volume);
    }

    @Test
    @DisplayName("TV increases channel when on")
    public void tvTestIncreaseChannelWhenOn(){
        tv.turnOn();
        tv.increaseChannel(5);
        assertEquals(6, tv.channel);
    }

    @Test
    @DisplayName("TV increases channel multiple times")
    public void tvTestIncreaseChannelMultiple(){
        tv.turnOn();
        tv.increaseChannel(5);
        assertEquals(6, tv.channel);

        tv.increaseChannel(5);
        assertEquals(11, tv.channel);
    }

    @Test
    @DisplayName("TV does not increase channel when off")
    public void tvTestIncreaseChannelWhenOff(){
        assertEquals("off", tv.power);
        tv.increaseChannel(5);
        assertEquals(1, tv.channel);
    }

    @Test
    @DisplayName("TV does not exceed max channel of 100")
    public void tvTestIncreaseChannelLimit(){
        tv.turnOn();
        tv.increaseChannel(200);
        assertEquals(100, tv.channel);
    }

    @Test
    @DisplayName("TV decreases channel when on")
    public void tvTestDecreaseChannelWhenOn(){
        tv.turnOn();
        tv.increaseChannel(10);
        assertEquals(11, tv.channel);

        tv.decreaseChannel(5);
        assertEquals(6, tv.channel);
    }

    @Test
    @DisplayName("TV does not decrease channel when off")
    public void tvTestDecreaseChannelWhenOff(){
        assertEquals("off", tv.power);
        tv.decreaseChannel(5);
        assertEquals(1, tv.channel);
    }

    @Test
    @DisplayName("TV does not go below min channel of 1")
    public void tvTestDecreaseChannelFloor(){
        tv.turnOn();
        tv.decreaseChannel(10);
        assertEquals(1, tv.channel);
    }
}