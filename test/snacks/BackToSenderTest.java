package snacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


}
