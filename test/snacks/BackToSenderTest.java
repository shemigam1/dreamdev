package snacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackToSenderTest {
    private BackToSender payroll;
    @BeforeEach
    public void setup(){
        payroll = new BackToSender();
    }

    @Test
    @DisplayName("Function should return an integer")
    public void isInt(){
        assertInstanceOf(Integer.class, payroll.payout(5));
    }

    @Test
    @DisplayName("Function should return correct value of < 50")
    public void lessThanFifty(){
        assertEquals(12840, payroll.payout(49));
    }

    @Test
    @DisplayName("Function should return correct value of < 60")
    public void lessThanSixty(){
        assertEquals(17000, payroll.payout(59));
    }




}
