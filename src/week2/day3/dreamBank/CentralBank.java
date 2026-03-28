package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidBankNameException;

import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private Map<String, Bank> bankRegistry = new HashMap<>();

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
}
