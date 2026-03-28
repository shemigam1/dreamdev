package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidAccountNumberException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private Map<Integer, Account> banks = new HashMap<>();

    public Bank(String name){
        this.name = name;
    }

    public int createAccount(String accountName, String pin) {
        Account account = new Account(accountName, pin);
        int accountNumber = account.getAccountNumber();
        banks.put(accountNumber, account);
        return accountNumber;
    }

    public BigDecimal checkBalance(int accountNumber, String pin) {
        validateAccountNumber(accountNumber);
        Account account = banks.get(accountNumber);
        return account.checkBalance(pin);
    }

    public void validateAccountNumber(int accountNumber){
        if (!banks.containsKey(accountNumber)){
            throw new InvalidAccountNumberException("Account doesn't exist");
        }else return;

    }

    public void deposit(int accountNumber, String pin, BigDecimal amount) {
        validateAccountNumber(accountNumber);
        Account account = banks.get(accountNumber);
        account.deposit(amount, pin);
    }

    public void withdraw(int accountNumber, String pin, BigDecimal amount) {
        validateAccountNumber(accountNumber);
        Account account = banks.get(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int accountNumber1, int accountNumber2, BigDecimal amount, String pin) {
        validateAccountNumber(accountNumber1);
        validateAccountNumber(accountNumber2);
        Account account1 = banks.get(accountNumber1);
        Account account2 = banks.get(accountNumber2);
        account1.withdraw(amount, pin);
        account2.deposit(amount, pin);
    }


}
