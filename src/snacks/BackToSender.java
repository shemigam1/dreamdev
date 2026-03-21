package snacks;

import java.util.Scanner;

public class BackToSender {

    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of deliveries made");
        int numOfDeliveries = scanner.nextInt();
        int payout = payout(numOfDeliveries);
        System.out.printf("you get %d for making %d deliveries%n", payout, numOfDeliveries);
    }

    public static int payout(int numOfDeliveries){
        int basePay = 5000;
        int commissions = calculateCommission(numOfDeliveries);
        return basePay + commissions;
    }

    private static int calculateCommission(int numOfDeliveries){
        int rate = 160;
        if (numOfDeliveries >= 50) rate = 200;
        if (numOfDeliveries >= 60) rate = 250;
        if (numOfDeliveries >= 70) rate = 500;

        return rate * numOfDeliveries;
    }


}
