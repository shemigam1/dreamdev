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
                Enter the Type of Pizza you want to buy
                Press 1 -> Sapa Size (4 slices)
                Press 2 -> Small Money (6 slices)
                Press 3 -> Big Boys (8 slices)
                Press 4 -> Odogwu (12 slices)
                """;
        System.out.println(typePrompt);
        int type = scanner.nextInt();

        int pricePerBox = 0;
        int slices = 0;
        String size;
        switch (type) {
            case 1 -> {
                slices = 4;
                pricePerBox = 2500;
                size = "Sapa size";
            }
            case 2 -> {
                slices = 6;
                pricePerBox = 2900;
                size = "Small money size";
            }
            case 3 -> {
                slices = 8;
                pricePerBox = 4000;
                size = "Big boys size";
            }
            case 4-> {
                slices = 12;
                pricePerBox = 5200;
                size = "Odogwu size";
            }
            default -> {
                System.out.println("Please pick a valid value");
                return;
            }
        }
        int boxes = Math.ceilDiv(guests, slices);
        int remainder = (slices*boxes) - guests;
        int price = pricePerBox * boxes;

        System.out.printf("Number of Pizza Boxes to buy = %d boxes. %n(%s contains %d per box, %d boxes should be sufficient " +
                "for %d persons as it would contain %d slices in all%n", boxes, size, slices, boxes, guests, boxes*slices);
        System.out.printf("Number of left over slices after serving = %d slices. %n(after serving %d slices, you should have " +
                "%d slices left)%n", remainder, guests, remainder);
        System.out.printf("Price = %d. %n(%d per box for %d boxes)%n", price, pricePerBox, boxes);
    }
}
