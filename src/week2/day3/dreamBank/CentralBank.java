package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidBankNameException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private Map<String, Bank> bankRegistry = new HashMap<>();
    private BigDecimal federalReserve = new BigDecimal(0);
    private BigDecimal charges = new BigDecimal("0.75");

    public String registerBank(String bankName, Bank bank) {
        String sanitized = sanitize(bankName);
        validateBankName(sanitized);
        bankRegistry.put(sanitized, bank);
        return bankName;
    }

    private void validateBankName(String bankName){
        if (bankRegistry.containsKey(bankName)) throw new InvalidBankNameException("Bank exists already");
    }

    private void validateBankExists(String bankName) {
        if (!bankRegistry.containsKey(bankName))
            throw new InvalidBankNameException("Bank not found");
    }

    public String sanitize(String bankName) {
        return bankName.replaceAll("\\s+", "").toLowerCase();
    }

    public void transferBetweenBanks(String senderBankName, int senderAccount, String receiverBankName, int receiverAccount, BigDecimal amount, String pin) {
        senderBankName = sanitize(senderBankName);
        receiverBankName = sanitize(receiverBankName);
        validateBankExists(senderBankName);
        validateBankExists(receiverBankName);
        Bank senderBank = bankRegistry.get(senderBankName);
        senderBank.withdraw(senderAccount, pin, amount);
        this.federalReserve = this.federalReserve.add(amount);
        Bank receiverBank = bankRegistry.get(receiverBankName);
        receiverBank.deposit(receiverAccount, amount);
        this.federalReserve = this.federalReserve.subtract(amount);
    }

    public int getBankRegistrySize() {
        return this.bankRegistry.size();
    }

    public Bank getBank(String bankName) {
        return bankRegistry.get(bankName);
    }
}
