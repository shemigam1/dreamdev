package snacks;

import java.util.Scanner;

public class PizzaWahala {
    public static void main(String... args){
        System.out.println("Welcome to The Best Pizza Place in the Trenches");
        System.out.println("Iya Moses Pizza Joint, Ajegunle");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of guests you have");
        int guests = scanner.nextInt();

        String typePrompt = """
                Enter the Type of Pizza you wat to buy
                Press 1 -> Sapa Size (4 slices)
                Press 2 -> Small Money (6 slices)
                Press 3 -> Big Boys (8 slices)
                Press 4 -> Odogwu (12 slices)
                """;
        System.out.println(typePrompt);
        int type = scanner.nextInt();

    }
}
