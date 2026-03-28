package week2.day3.dreamBankTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Account;
import week2.day3.dreamBank.Bank;
import week2.day3.dreamBank.exceptions.InvalidAccountNumberException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    Bank bank;
    String accountName = "semil";
    String pin = "1738";
    @BeforeEach
    public void setup(){
        bank = new Bank("Dream Bank");
//        bank.deleteAll();
    }
    @Test
    public void createAccount_checkAccountBalanceIsZeroTest(){

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
    }

//    @Test
//    public void createDuplicateAccounts_withSameNameThrowsExceptionTest(){
//        bank.createAccount(accountName, pin);
//        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountName, pin));
//        assertThrows(InvalidAccountNameException.class , ()->bank.createAccount(accountName, pin));
//    }

    @Test
    public void createMultipleAccountsTest(){
        bank.createAccount(accountName, pin);
        int accountNumber = 5001;
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
        bank.createAccount("lore", "1739");
        int accountNumber2 = 5002;
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber2, "1739"));
    }

    @Test
    public void createAccount_deposit1000BalanceShould_be1000Test(){

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
        bank.deposit(accountNumber, pin, BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber, pin));
    }

    @Test
    public void createAccount_deposit1000Withdraw500BalanceShould_be500Test(){

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
        bank.deposit(accountNumber, pin, BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber, pin));
        bank.withdraw(accountNumber, pin, BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), bank.checkBalance(accountNumber, pin));
    }
}
