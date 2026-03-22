package snacks.week1;

import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String... args){
        System.out.println("Hello, kindly enter details to verify");
        Scanner scanner = new Scanner(System.in);

        String cardNumber = scanner.nextLine().trim();
        String cardType = checkType(cardNumber);
        String isValid = validate(cardNumber);
        int cardDigitLength = String.valueOf(cardNumber).length();
        if (!(cardDigitLength >= 13 && cardDigitLength <= 16)) {
            isValid = "Invalid";
        }

        System.out.println("********************************");
        System.out.printf("***Credit Card Type: %s%n", cardType);
        System.out.printf("***Credit Card Number: %s%n", cardNumber);
        System.out.printf("***Credit Card Digit Length: %d%n", cardDigitLength);
        System.out.printf("***Credit Card Validity Status: %s%n", isValid);
    }

    public static String checkType(String cardString){


        String cardType = "Invalid Card";
        if (cardString.charAt(0) == '4') cardType = "Visa Card";
        if (cardString.charAt(0) == '5') cardType = "MasterCard";
        if (cardString.charAt(0) == '6') cardType = "Discover Card";
        if (cardString.charAt(0) == '3' && cardString.charAt(1) == '7') cardType = "American Express Card";
        return cardType;
    }

    public static String validate(String cardString){
        int even = 0;
        int odd = 0;

        for (int i = cardString.length() - 2; i >=0  ; i -= 2){
            int num = Character.getNumericValue(cardString.charAt(i)) * 2;
            if (num > 9){
                String numString = String.valueOf(num);
                even += Character.getNumericValue(numString.charAt(0)) + Character.getNumericValue(numString.charAt(1));
                continue;
            }
            even += num;
        }

        for (int j = cardString.length() - 1; j >=0  ; j -= 2){
            odd += Character.getNumericValue(cardString.charAt(j));
        }
        boolean isValid = (odd + even) % 10 == 0;
        if (isValid) return "Valid";
        return "Invalid";
    }

}
