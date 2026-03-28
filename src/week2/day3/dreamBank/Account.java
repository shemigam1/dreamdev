package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidAmountException;
import week2.day3.dreamBank.exceptions.InvalidPinException;

import java.math.BigDecimal;
import java.util.Random;

public class Account {
    private String name;
    private String pin;
    private BigDecimal balance = new BigDecimal(0);
    private static int serialNumber = 5000;
    private int accountNumber;

    public Account(String name, String pin){
        this.name = name;
        this.pin = pin;
        this.accountNumber = generateAccountNumber();
    }

    public BigDecimal checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }

    public void deposit(BigDecimal amount, String pin) {
        validatePin(pin);
        validateAmount(amount);
        this.balance = balance.add(amount);
    }

    public void validateAmount(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("Amount deposited cannot be negative");
        }
    }

    public void validatePin(String pin){
        if (this.pin == pin) return;
        else throw new InvalidPinException("Wrong pin");
    }


    public void withdraw(BigDecimal amount, String pin) {
        validatePin(pin);
        validateAmount(amount);
        this.balance = balance.subtract(amount);
    }

    public void updatePin(String pin, String newPin) {
        if (newPin.length() != 4) throw new InvalidPinException("PIN must be 4 digits");
        try {
            validatePin(pin);
        } catch (Exception e) {
            throw new InvalidPinException("wrong pin");
        }
        this.pin = newPin;
    }


    public static int generateAccountNumber() {
        serialNumber += 1;
        return serialNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
}
