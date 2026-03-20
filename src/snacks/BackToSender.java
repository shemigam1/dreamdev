package snacks;

public class BackToSender {

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
