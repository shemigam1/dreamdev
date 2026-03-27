package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidAmountException;
import week2.day3.dreamBank.exceptions.InvalidPinException;

import java.math.BigDecimal;

public class Account {
    private String name;
    private String pin;
    private BigDecimal balance = new BigDecimal(0);

    public Account(String name, String pin){
        this.name = name;
        this.pin = pin;
    }

    public BigDecimal checkBalance(String pin) {
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

    public void validatePin(String amount){
        if (this.pin == pin) return;
        else throw new InvalidPinException("Wrong pin");
    }



}
