package snacks.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutApp {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the customer's name?");
        String customerName = scanner.nextLine();
        String cashierName = "";
        double amountPaid = 0;
        double discount = 0;
        ArrayList<String> productList = new ArrayList<>();
        ArrayList<Integer> unitsList = new ArrayList<>();
        ArrayList<Integer> pricesList = new ArrayList<>();

        while (true){
            System.out.println("What did the user buy?");
            String product = scanner.nextLine();
            productList.add(product);

            System.out.println("How many pieces");
            int unit = scanner.nextInt();
            scanner.nextLine();
            unitsList.add(unit);

            System.out.println("How much per unit");
            int price = scanner.nextInt();
            scanner.nextLine();
            pricesList.add(price);

            System.out.println("Add more items?");
            String proceed = scanner.nextLine();
            if (!proceed.equalsIgnoreCase("yes")) {
                System.out.println("What is your name?");
                cashierName = scanner.nextLine();

                System.out.println("How much discount will he get?");
                discount = scanner.nextDouble();
                break;
            }
        }

        System.out.println(productList);
        System.out.println(unitsList);

        String receiptHeader = """
                SEMICOLON STORES
                MAIN BRANCH
                LOCATION: 312, HERBERT MACAULAY, SABO YABA, LAGOS.
                TEL: 0328838828229
                Date: 18-Dec-22 8:48:11 pm
                """;
        receiptHeader += String.format("Cashier Name: %s%n", cashierName);
        receiptHeader += String.format("Customer Name: %s%n", customerName);
        receiptHeader += """
                ===================================================
                ITEM   QTY   PRICE   TOTAL(NGN)
                ---------------------------------------------------
                """;

        String prices = "";
        for (int i = 0; i < productList.size(); i++) {
            prices += String.format("%s       %d    %.2f     %.2f%n", productList.get(i),
                    unitsList.get(i), (float) pricesList.get(i), (float) unitsList.get(i) * pricesList.get(i));
        }

        double subTotal = 0;
        for (int i = 0; i < unitsList.size(); i++){
            subTotal += (double)(unitsList.get(i) * pricesList.get(i));
        }
        discount = (discount/100) * subTotal;
        double vat = 0.175 * subTotal;
        double billTotal = subTotal + vat - discount;


        String postReceiptTemplate = """
             ---------------------------------------------------
                                   Sub Total:        %.2f
                                    Discount:        %.2f
                                VAT @ 17.50%%:        %.2f
             ===================================================
                                  Bill Total:        %.2f
             """;
        String footerPre = """
                ===================================================
                THIS IS NOT A RECEIPT KINDLY PAY %.2f
                ===================================================
                """;
        String postReceipt = String.format(postReceiptTemplate, subTotal, discount, vat, billTotal);
        String preReceipt = receiptHeader + prices + postReceipt + String.format(footerPre, billTotal);
        System.out.println(preReceipt);

        System.out.println("How much did the customer give to you?");
        double cashPaid = scanner.nextDouble();
        if (cashPaid < billTotal){
            System.out.printf("cash paid %.2f cannot cover total bill %.2f%n", cashPaid, billTotal);
            return;
        }
        double balance = cashPaid - billTotal;

        String footerPostTemplate = """
                                 Amount Paid:    %.2f
                                 Balance:        %.2f
             ===================================================
                        THANK YOU FOR SHOPPING WITH US
             """;

        String footerPost = String.format(footerPostTemplate, cashPaid, balance);

        String receipt = receiptHeader + prices + postReceipt + footerPost;

        System.out.println(receipt);
    }
}
