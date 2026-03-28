package week2.day3.dreamBankTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Account;
import week2.day3.dreamBank.Bank;
import week2.day3.dreamBank.exceptions.InvalidAccountNumberException;
import week2.day3.dreamBank.exceptions.InvalidAmountException;
import week2.day3.dreamBank.exceptions.InvalidPinException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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
        bank.deposit(accountNumber, BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber, pin));
    }

    @Test
    public void createAccount_deposit1000Withdraw500BalanceShould_be500Test(){

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
        bank.deposit(accountNumber,  BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber, pin));
        bank.withdraw(accountNumber, pin, BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), bank.checkBalance(accountNumber, pin));
    }

    @Test
    public void createAccount_deposit1000Withdraw1500ShouldThrowExceptionTest(){

        int accountNumber = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber, pin));
        bank.deposit(accountNumber,  BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber, pin));
        assertThrows(InvalidAmountException.class, ()->bank.withdraw(accountNumber, pin, BigDecimal.valueOf(1500)));
    }

    @Test
    public void createTwoAccounts_TransferMoneyBetweenThem_accountBalanceShouldReflectTest(){
        int accountNumber1 = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber1, pin));
        bank.deposit(accountNumber1,  BigDecimal.valueOf(1_000));
        assertEquals(BigDecimal.valueOf(1000), bank.checkBalance(accountNumber1, pin));
        int accountNumber2 = bank.createAccount(accountName, pin);
        assertEquals(BigDecimal.ZERO, bank.checkBalance(accountNumber2, pin));

        bank.transfer(accountNumber1, accountNumber2, BigDecimal.valueOf(500), pin);
        assertEquals(BigDecimal.valueOf(500), bank.checkBalance(accountNumber1, pin));
        assertEquals(BigDecimal.valueOf(500), bank.checkBalance(accountNumber2, pin));
    }

    @Test
    public void deposit_invalidAccountNumber_throwsExceptionTest() {
        assertThrows(InvalidAccountNumberException.class, () -> bank.deposit(9999, BigDecimal.valueOf(500)));
    }

    @Test
    public void withdraw_invalidAccountNumber_throwsExceptionTest() {
        assertThrows(InvalidAccountNumberException.class, () -> bank.withdraw(9999, pin, BigDecimal.valueOf(500)));
    }

    @Test
    public void checkBalance_invalidAccountNumber_throwsExceptionTest() {
        assertThrows(InvalidAccountNumberException.class, () -> bank.checkBalance(9999, pin));
    }

    @Test
    public void checkBalance_wrongPin_throwsExceptionTest() {
        int accountNumber = bank.createAccount(accountName, pin);
        assertThrows(InvalidPinException.class, () -> bank.checkBalance(accountNumber, "0000"));
    }

    @Test
    public void withdraw_wrongPin_throwsExceptionTest() {
        int accountNumber = bank.createAccount(accountName, pin);
        bank.deposit(accountNumber, BigDecimal.valueOf(500));
        assertThrows(InvalidPinException.class, () -> bank.withdraw(accountNumber, "0000", BigDecimal.valueOf(200)));
    }

    @Test
    public void checkBalance_invalidAccountNumber(){
        assertThrows(InvalidAccountNumberException.class, ()->bank.checkBalance(23445, "2334"));
    }

    @Test
    public void twoAccountsSameName_getDifferentAccountNumbersTest() {
        int acc1 = bank.createAccount(accountName, pin);
        int acc2 = bank.createAccount(accountName, pin);
        assertNotEquals(acc1, acc2);
    }

    @Test
    public void transfer_insufficientFunds_throwsExceptionTest() {
        int acc1 = bank.createAccount(accountName, pin);
        int acc2 = bank.createAccount("lore", "1739");
        bank.deposit(acc1, BigDecimal.valueOf(200));
        assertThrows(InvalidAmountException.class, () -> bank.transfer(acc1, acc2, BigDecimal.valueOf(500), pin));
    }

    @Test
    public void transfer_invalidDestination_throwsExceptionTest() {
        int acc1 = bank.createAccount(accountName, pin);
        bank.deposit(acc1, BigDecimal.valueOf(500));
        assertThrows(InvalidAccountNumberException.class, () -> bank.transfer(acc1, 9999, BigDecimal.valueOf(200), pin));
    }

    @Test
    public void transfer_invalidSource_throwsExceptionTest() {
        int acc2 = bank.createAccount("lore", "1739");
        assertThrows(InvalidAccountNumberException.class, () -> bank.transfer(9999, acc2, BigDecimal.valueOf(200), pin));
    }

}
