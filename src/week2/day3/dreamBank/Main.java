package week2.day3.dreamBank;

import week2.day3.dreamBank.exceptions.InvalidAccountNumberException;
import week2.day3.dreamBank.exceptions.InvalidAmountException;
import week2.day3.dreamBank.exceptions.InvalidBankNameException;
import week2.day3.dreamBank.exceptions.InvalidPinException;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    static CentralBank cbn = new CentralBank();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                ╔══════════════════════════════════════╗
                ║         WELCOME TO DREAM BANK        ║
                ║     Your all-in-one financial partner║
                ╚══════════════════════════════════════╝
                """);

        while (true) {
            System.out.println("""
                    ── Main Menu ──────────────────────────
                    1. Create a bank
                    2. Select a bank
                    3. Exit
                    ───────────────────────────────────────""");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> createBank();
                case "2" -> selectBank();
                case "3" -> {
                    System.out.println("\nThank you for banking with Dream Bank. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
    }


    private static void createBank() {
        System.out.print("\nEnter bank name: ");
        String bankName = scanner.nextLine().trim();
        try {
            Bank bank = new Bank(bankName);
            cbn.registerBank(bankName, bank);
            System.out.println("Bank \"" + bankName + "\" created successfully!\n");
        } catch (InvalidBankNameException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void selectBank() {
        if (cbn.getBankRegistrySize() == 0) {
            System.out.println("\nNo banks registered yet. Create a bank first.\n");
            return;
        }
        System.out.print("\nEnter bank name: ");
        String bankName = scanner.nextLine().trim();
        try {
            bankName = cbn.sanitize(bankName);
            Bank bank = cbn.getBank(bankName);
            bankMenu(bank);
        } catch (InvalidBankNameException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }


    private static void bankMenu(Bank bank) {
        while (true) {
            System.out.println("\n── " + bank.getBankName() + " ──────────────────────────");
            System.out.println("""
                    1. Create an account
                    2. Log in
                    3. Back to main menu
                    ───────────────────────────────────────""");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> createAccount(bank);
                case "2" -> login(bank);
                case "3" -> { return; }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAccount(Bank bank) {
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Set a 4-digit PIN: ");
        String pin = scanner.nextLine().trim();
        try {
            int accountNumber = bank.createAccount(name, pin);
            System.out.println("Account created! Your account number is: " + accountNumber + "\n");
        } catch (InvalidPinException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void login(Bank bank) {
        System.out.print("\nEnter account number: ");
        String input = scanner.nextLine().trim();
        int accountNumber;
        try {
            accountNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number.\n");
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine().trim();

        try {
            bank.checkBalance(accountNumber, pin);
            System.out.println("Login successful!\n");
            accountMenu(bank, accountNumber, pin);
        } catch (InvalidAccountNumberException e) {
            System.out.println("Error: Account not found.\n");
        } catch (InvalidPinException e) {
            System.out.println("Error: Wrong PIN.\n");
        }
    }


    private static void accountMenu(Bank bank, int accountNumber, String pin) {
        while (true) {
            System.out.println("── Account Menu ───────────────────────────");
            System.out.println("""
                    1. Check balance
                    2. Deposit
                    3. Withdraw
                    4. Transfer (same bank)
                    5. Transfer (inter-bank)
                    6. Update PIN
                    7. Log out
                    ───────────────────────────────────────""");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> checkBalance(bank, accountNumber, pin);
                case "2" -> deposit(bank, accountNumber);
                case "3" -> {
                    pin = withdraw(bank, accountNumber, pin);
                }
                case "4" -> intraBankTransfer(bank, accountNumber, pin);
                case "5" -> interBankTransfer(bank, accountNumber, pin);

                case "7" -> {
                    System.out.println("Logged out successfully.\n");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void checkBalance(Bank bank, int accountNumber, String pin) {
        try {
            BigDecimal balance = bank.checkBalance(accountNumber, pin);
            System.out.println("\nCurrent balance: ₦" + balance + "\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    private static void deposit(Bank bank, int accountNumber) {
        System.out.print("\nEnter amount to deposit: ₦");
        try {
            BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
            bank.deposit(accountNumber, amount);
            System.out.println("Deposit successful!\n");
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.\n");
        }
    }

    private static String withdraw(Bank bank, int accountNumber, String pin) {
        System.out.print("\nEnter amount to withdraw: ₦");
        try {
            BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
            bank.withdraw(accountNumber, pin, amount);
            System.out.println("Withdrawal successful!\n");
        } catch (InvalidAmountException | InvalidPinException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.\n");
        }
        return pin;
    }

    private static void intraBankTransfer(Bank bank, int accountNumber, String pin) {
        System.out.print("\nEnter recipient account number: ");
        try {
            int recipientAccount = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter amount to transfer: ₦");
            BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
            bank.transfer(accountNumber, recipientAccount, amount, pin);
            System.out.println("Transfer successful!\n");
        } catch (InvalidAccountNumberException | InvalidAmountException | InvalidPinException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input entered.\n");
        }
    }

    private static void interBankTransfer(Bank bank, int accountNumber, String pin) {
        System.out.print("\nEnter recipient bank name: ");
        String receiverBankName = scanner.nextLine().trim();
        System.out.print("Enter recipient account number: ");
        try {
            int recipientAccount = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter amount to transfer: ₦");
            BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
            cbn.transferBetweenBanks(
                    bank.getBankName(), accountNumber,
                    receiverBankName, recipientAccount,
                    amount, pin
            );
            System.out.println("Inter-bank transfer successful!\n");
        } catch (InvalidBankNameException | InvalidAccountNumberException |
                 InvalidAmountException | InvalidPinException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input entered.\n");
        }
    }

}
