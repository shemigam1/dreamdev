package week2.day3.dreamBankTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.day3.dreamBank.Bank;
import week2.day3.dreamBank.CentralBank;
import week2.day3.dreamBank.exceptions.InvalidBankNameException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CentralBankTest {
    CentralBank cbn;
    Bank dreamBank;
    @BeforeEach
    public void setup(){
        cbn = new CentralBank();
        dreamBank = new Bank("Dream Bank");
    }
    @Test
    public void createBank_withZeroAccountsTest(){
        cbn.registerBank(dreamBank.getBankName(), dreamBank);
    }

    @Test
    public void createDuplicateBanks_shouldThrowExceptionTest(){
        Bank dreamBank = new Bank("Dream Bank");
        cbn.registerBank(dreamBank.getBankName(), dreamBank);
        Bank fakeDreamBank = new Bank("Dream Bank");
        assertThrows(InvalidBankNameException.class, ()->cbn.registerBank(fakeDreamBank.getBankName(), fakeDreamBank));
    }

    @Test
    public void createTwoBanks_createTwoAccounts_transferMoneyBetweenBanksTest(){
        cbn.registerBank(dreamBank.getBankName(), dreamBank);
        Bank moniepoint =  new Bank("Moniepoint");
        cbn.registerBank(moniepoint.getBankName(), moniepoint);
        int semil = dreamBank.createAccount("semilore", "1738");
        int chibuzor = moniepoint.createAccount("chibuzor", "4190");
        assertEquals(0, dreamBank.checkBalance(semil, "1738").compareTo(BigDecimal.ZERO));
        assertEquals(0, moniepoint.checkBalance(chibuzor, "4190").compareTo(BigDecimal.ZERO));
        dreamBank.deposit(semil, BigDecimal.valueOf(10_000));
        cbn.transferBetweenBanks(dreamBank, semil, moniepoint, chibuzor, BigDecimal.valueOf(8_000), "1738");
        assertEquals(0, dreamBank.checkBalance(semil, "1738").compareTo(BigDecimal.valueOf(2_000)));
        assertEquals(0, moniepoint.checkBalance(chibuzor, "4190").compareTo(BigDecimal.valueOf(8_000)));
    }
}
