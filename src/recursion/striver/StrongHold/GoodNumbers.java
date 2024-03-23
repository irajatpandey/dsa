package recursion.striver.StrongHold;

import java.util.ArrayList;
import java.util.List;

public class GoodNumbers {
    public static void main(String[] args) {
        int a = 840;
        int b = 850;
        int digitToAvoid = 6;
        List<Integer> goodNumbers = new ArrayList<>();
        findGoodNumbersInRange(a, b, digitToAvoid, goodNumbers);
        System.out.println("Good numbers = " + goodNumbers);
    }

    // Recursive function to find all good numbers in the range from 'a' to 'b'
    public static void findGoodNumbersInRange(int num, int b, int digitToAvoid, List<Integer> goodNumbers) {
        // Base case: If the number exceeds 'b', stop recursion
        if (num > b) {
            return;
        }

        // Check if the number doesn't contain the specified digit to avoid and is a good number
        if (!containsDigit(num, digitToAvoid) && isGoodNumber(num, digitToAvoid)) {
            goodNumbers.add(num); // Add the number to the list of good numbers
        }

        // Recursively call with the next number
        findGoodNumbersInRange(num + 1, b, digitToAvoid, goodNumbers);
    }

    // Function to check if a number is good
    public static boolean isGoodNumber(int num, int digitToAvoid) {
        if (num == 0) {
            return true;
        }

        int sumOfRightDigits = 0;
        int lastDigit = 0;
        boolean firstDigit = true;

        while (num > 0) {
            lastDigit = num % 10;
            num /= 10;

            if (!firstDigit && lastDigit <= sumOfRightDigits) {
                return false;
            }

            if (lastDigit == digitToAvoid) {
                return false;
            }

            sumOfRightDigits += lastDigit;
            firstDigit = false;
        }

        return true;
    }

    // Function to check if a number contains a specific digit
    public static boolean containsDigit(int num, int digit) {
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit == digit) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

}