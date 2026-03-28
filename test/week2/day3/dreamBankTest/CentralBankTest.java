package week2.day3.dreamBankTest;

import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.CentralBank;
import week2.day3.dreamBank.exceptions.InvalidBankNameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CentralBankTest {
    @Test
    public void createBank_withZeroAccountsTest(){
        CentralBank cbn = new CentralBank();
        cbn.registerBank("Dream Bank");
    }

    @Test
    public void createDuplicateBanks_shouldThrowExceptionTest(){
        CentralBank cbn = new CentralBank();
        cbn.registerBank("Dream Bank");
        assertThrows(InvalidBankNameException.class, ()->cbn.registerBank("Dream Bank"));
    }
}
