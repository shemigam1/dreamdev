package week2.day1.assignment;

import java.util.Scanner;

public class Zones {

    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your state");

        String state = scanner.nextLine();
        String zone = getZone(state);
        System.out.printf("%s is in %s zone", state, zone);
    }
    public static String getZone(String state){
        String[] northCentral = new String[] {"benue", "fct", "kogi", "nasarawa", "niger", "plateau"};
        String[] northEast = new String[] {"adamawa", "bauchi", "borno", "gombe", "taraba", "yobe"};
        String[] northWest = new String[] {"kaduna", "katsina", "kano", "kebbi", "sokoto", "jigawa", "zamfara"};
        String[] southEast = new String[] {"abia", "anambra", "ebonyi", "enugu", "imo"};
        String[] southSouth = new String[] {"akwa-ibom", "bayelsa", "cross-river", "delta", "edo", "rivers"};
        String[] southWest = new String[] {"ekiti", "lagos", "osun", "ondo", "ogun", "oyo"};

        String[][] zones  = new String[][] {northCentral, northWest, northEast, southEast, southSouth, southWest};
        String[] zoneNames = {"North Central", "North West", "North East", "South East", "South South", "South West"};

        for (int i = 0; i < zones.length; i++) {
            for (String place : zones[i]) {
                if (place.equalsIgnoreCase(state)) {
                    return zoneNames[i];
                }
            }
        }
        return "O.Y.O lo wa";
    }


}
