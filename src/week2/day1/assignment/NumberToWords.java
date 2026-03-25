package week2.day1.assignment;

public class NumberToWords {
    public static String converter(int number){
            if (number == 0) return "zero";

            String[] ones = {"", "one", "two", "three", "four", "five", "fix", "seven", "eight", "nine",
                    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                    "seventeen", "eighteen", "nineteen"};
            String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
            String[] thousands = {"", "thousand", "million", "billion"};

            String result = "";
            int groupIndex = 0;

            while (number > 0) {
                int chunk = number % 1000;
                if (chunk != 0) {
                    result = convertBits(chunk, ones, tens) + " " + thousands[groupIndex] + " " + result;
                }
                number /= 1000;
                groupIndex++;
            }

            return result.trim();
        }

        private static String convertBits(int number, String[] ones, String[] tens) {
            String result = "";
            if (number >= 100) {
                result += ones[number / 100] + " hundred ";
                number %= 100;
            }
            if (number >= 20) {
                result += tens[number / 10] + " ";
                number %= 10;
            }
            if (number > 0) {
                result += ones[number];
            }
            return result.trim();
    }
}
