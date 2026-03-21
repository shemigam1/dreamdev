package snacks;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutApp {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the customer's name?");
        String name = scanner.nextLine();
        ArrayList<String> productList = new ArrayList<>();
        ArrayList<Integer> unitsList = new ArrayList<>();

        while (true){
            System.out.println("What did the user buy?");
            String product = scanner.nextLine();
            productList.add(product);

            System.out.println("How many pieces");
            int unit = scanner.nextInt();
            scanner.nextLine();
            unitsList.add(unit);

            System.out.println("Add more items?");
            String proceed = scanner.nextLine();
            if (!proceed.equalsIgnoreCase("yes")) break;
        }

        System.out.println(productList);
        System.out.println(unitsList);

        String preReceipt = """
                SEMICOLON STORES
                MAIN BRANCH
                LOCATION: 312, HERBERT MACAULAY, SABO YABA, LAGOS.
                TEL: 0328838828229
                Date: 18-Dec-22 8:48:11 pm
                Cashier: Tosin Eniolorunda
                Customer Name: Semilore
                ===================================================
                              ITEM   QTY   PRICE   TOTAL(NGN)
                ---------------------------------------------------
                           %s       %d       %f      %f
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
                """
    }
}
