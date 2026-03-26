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
    public void createAccount_withBalanceOfZeroTest(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }

    @Test
    @DisplayName("Deposit 100 into account, balance should be 100")
    public void deposit100IntoAccount_BalanceIs100Test(){
        account.deposit(BigDecimal.valueOf(100), pin);
        assertEquals(BigDecimal.valueOf(100), account.checkBalance(pin));
    }
}
