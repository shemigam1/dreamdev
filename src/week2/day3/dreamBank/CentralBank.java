package week2.day3.dreamBank;

import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private Map<String, Bank> bankRegistry = new HashMap<>();

    public String registerBank(String bankName) {
        Bank newBank = new Bank(bankName);
        bankRegistry.put(bankName, newBank);
        return bankName;
    }


}
