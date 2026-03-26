package week2.day3.BankApp.exceptions;

public class InsufficientBalanceException extends BankAppException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}