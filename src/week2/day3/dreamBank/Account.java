package week2.day3.dreamBank;

import java.math.BigDecimal;

public class Account {
    private String name;
    private String pin;

    public Account(String name, String pin){
        this.name = name;
        this.pin = pin;
    }

    public BigDecimal checkBalance(String pin) {
        return BigDecimal.ZERO;
    }
}
