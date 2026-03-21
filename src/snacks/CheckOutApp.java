package snacks;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutApp {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the customer's name?");
        String customerName = scanner.nextLine();
        String cashierName;
        double discount;
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

        String preReceipt = """
                SEMICOLON STORES
                MAIN BRANCH
                LOCATION: 312, HERBERT MACAULAY, SABO YABA, LAGOS.
                TEL: 0328838828229
                Date: 18-Dec-22 8:48:11 pm
                """;
        preReceipt += String.format("Cashier Name: %s", cashierName);
        preReceipt += String.format("Customer Name: %s", customerName);
        preReceipt += """
                ===================================================
                ITEM   QTY   PRICE   TOTAL(NGN)
                ---------------------------------------------------
                """;

        String prices = "";
        for (int i = 0; i < productList.size(); i++) {
            prices += String.format("           %s       %d    %.2f     %.2f%n", productList.get(i),
                    unitsList.get(i), (float) pricesList.get(i), (float) unitsList.get(i) * pricesList.get(i));
        }

        double subTotal = 0;
        for (int i = 0; i < productList.size(); i++){

        }

        String postReceipt = """
                 ---------------------------------------------------
                                   Sub Total:        %f
                                    Discount:        %f
                                VAT @ 17.50%:        %f
                ===================================================
                                  Bill Total:        %f
                                 Amount Paid:        %f
                                     Balance:        %f
                ===================================================
                          THANK YOU FOR SHOPPING WITH US
                """;

        String receipt = preReceipt + prices + postReceipt;
        System.out.println(receipt);
    }
}
