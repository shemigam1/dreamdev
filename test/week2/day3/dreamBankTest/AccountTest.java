package week2.day3.dreamBankTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Account;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account account;
    private String pin;

    @BeforeEach
    void setup(){
         pin = "1738";
         account = new Account("semil", pin);
    }
    @Test
    @DisplayName("Create account with a balance of zero")
    public void createAccount_withBalanceOfZero(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }
}
