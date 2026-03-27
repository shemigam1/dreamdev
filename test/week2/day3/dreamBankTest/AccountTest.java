package week2.day3.dreamBankTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Account;
import week2.day3.dreamBank.exceptions.InvalidAmountException;
import week2.day3.dreamBank.exceptions.InvalidPinException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("Deposit -100 into account, should throw exception")
    public void depositNegative100IntoAccount_ThrowExceptionTest(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        assertThrows(InvalidAmountException.class, ()-> account.deposit(BigDecimal.valueOf(-100), pin));
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }

    @Test
    @DisplayName("Deposit 100 into account with wrong pin, should throw exception")
    public void deposit100IntoAccountWithWrongPin_ThrowExceptionTest(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        assertThrows(InvalidPinException.class, ()-> account.deposit(BigDecimal.valueOf(-100), "4190"));
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }

    @Test
    @DisplayName("Deposit 100 twice into account, balance should be 200")
    public void deposit100IntoAccountTwice_BalanceIs100Test(){
        account.deposit(BigDecimal.valueOf(100), pin);
        assertEquals(BigDecimal.valueOf(100), account.checkBalance(pin));
        account.deposit(BigDecimal.valueOf(100), pin);
        assertEquals(BigDecimal.valueOf(200), account.checkBalance(pin));
    }

    @Test
    @DisplayName("Deposit 100 into account, withdraw 100")
    public void deposit100IntoAccount_withdraw100Test(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        account.deposit(BigDecimal.valueOf(100), pin);
        assertEquals(BigDecimal.valueOf(100), account.checkBalance(pin));
        account.withdraw(BigDecimal.valueOf(100), pin);
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }

    @Test
    @DisplayName("Deposit 1000 into account, withdraw 100 and 600")
    public void deposit1000IntoAccount_withdraw100And600Test(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        account.deposit(BigDecimal.valueOf(1000), pin);
        assertEquals(BigDecimal.valueOf(1000), account.checkBalance(pin));
        account.withdraw(BigDecimal.valueOf(100), pin);
        account.withdraw(BigDecimal.valueOf(600), pin);
        assertEquals(BigDecimal.valueOf(300), account.checkBalance(pin));
    }

    @Test
    public void updatePinTest(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        assertThrows(InvalidPinException.class, ()->account.checkBalance("4190"));
        account.updatePin(pin, "4190");
        assertEquals(BigDecimal.ZERO, account.checkBalance("4190"));
    }
}
