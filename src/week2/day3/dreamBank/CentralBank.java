package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidBankNameException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private Map<String, Bank> bankRegistry = new HashMap<>();
    private BigDecimal federalReserve = new BigDecimal(0);

    public String registerBank(String bankName, Bank bank) {
        String sanitized = sanitize(bankName);
        validateBankName(sanitized);
        bankRegistry.put(sanitized, bank);
        return bankName;
    }

    private void validateBankName(String bankName){
        if (bankRegistry.containsKey(bankName)) throw new InvalidBankNameException("Bank exists already");
    }

    private String sanitize(String bankName) {
        return bankName.replaceAll("\\s+", "").toLowerCase();
    }

    public void transferBetweenBanks(Bank senderBank, int senderAccount, Bank receiverBank, int receiverAccount, BigDecimal amount, String pin) {
        senderBank.withdraw(senderAccount, pin, amount);
        this.federalReserve.add(amount);
        receiverBank.deposit(receiverAccount, amount);
        this.federalReserve.subtract(amount);
    }
}
