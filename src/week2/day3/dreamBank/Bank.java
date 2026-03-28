package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidAccountNameException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private Map<Integer, Account> banks = new HashMap<>();

    public Bank(String name){
        this.name = name;
    }

    public void createAccount(String accountName, String pin) {
        Account account = new Account(accountName, pin);
        int accountNumber = account.getAccountNumber();
        banks.put(accountNumber, account);
    }

    public BigDecimal checkBalance(int accountNumber, String pin) {
        Account account = banks.get(accountNumber);
        return account.checkBalance(pin);
    }

//    public void validateAccountName(String accountName){
//        if (banks.containsKey(accountName)){
//            throw new InvalidAccountNameException("Duplicate accounts are prohibited");
//        } else return;
//    }

    public void deposit(int accountNumber, String pin, BigDecimal bigDecimal) {
    }
}
