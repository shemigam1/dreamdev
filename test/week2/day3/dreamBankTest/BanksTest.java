package week2.day3.dreamBankTest;

import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Banks;

public class BanksTest {
    @Test
    public void createBank_withZeroAccounts(){
        Banks cbn = new Banks();
        cbn.registerBank("Dream Bank");
    }
}
