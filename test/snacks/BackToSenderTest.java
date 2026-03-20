package snacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackToSenderTest {
    @Test
    @DisplayName("Function should return an integer")
    public void isInt(){
        assertInstanceOf(Integer.class, BackToSender.payout(5));
    }

    @Test
    @DisplayName("Function should return correct value of < 50")
    public void lessThanFifty(){
        assertEquals(12840, BackToSender.payout(49));
    }

    @Test
    @DisplayName("Function should return correct value of < 60 >= 50")
    public void lessThanSixty(){
        assertEquals(16800, BackToSender.payout(59));
    }

    @Test
    @DisplayName("Function should return correct value of < 70 >= 60")
    public void lessThanSeventy(){
        assertEquals(22250, BackToSender.payout(69));
    }

    @Test
    @DisplayName("Function should return correct value of >= 70")
    public void moreThanSeventy(){
        assertEquals(40500, BackToSender.payout(71));
    }




}
