package week2.day3.dreamBank;

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
        if (this.pin == pin){
            this.balance = balance.add(amount);
        }
    }
}
