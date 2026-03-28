package week2.day3.dreamBankTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Account;
import week2.day3.dreamBank.Bank;
import week2.day3.dreamBank.exceptions.InvalidAccountNumberException;
import week2.day3.dreamBank.exceptions.InvalidAmountException;

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

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));

        int accountNumber2 = bank.createAccount("lore", "1739");
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

    @Test
    public void createAccount_deposit1000Withdraw1500ShouldThrowExceptionTest(){

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
        bank.deposit(accountNumber, pin, BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber, pin));
        assertThrows(InvalidAmountException.class, ()->bank.withdraw(accountNumber, pin, BigDecimal.valueOf(1500)));
    }

    @Test
    public void createTwoAccounts_TransferMoneyBetweenThem_accountBalanceShouldReflectTest(){
        int accountNumber1 = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber1, pin));
        bank.deposit(accountNumber1, pin, BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber1, pin));
        int accountNumber2 = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber2, pin));

        bank.transfer(accountNumber1, accountNumber2, BigDecimal.valueOf(500), pin);
        assertEquals(BigDecimal.valueOf(500), bank.checkBalance(accountNumber1, pin));
        assertEquals(BigDecimal.valueOf(500), bank.checkBalance(accountNumber2, pin));
    }
}
