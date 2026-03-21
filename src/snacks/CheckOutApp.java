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
    }
}
