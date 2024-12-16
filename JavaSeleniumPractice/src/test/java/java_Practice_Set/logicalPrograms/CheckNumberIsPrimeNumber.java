package java_Practice_Set.logicalPrograms;

import java.util.Scanner;

public class CheckNumberIsPrimeNumber {
    public static void main(String[] args) {
        /**
         * If number is <=1 its not a prime number
         * if number is divisible by 2 to number-1 then its not a prime no.
         */
        // Assume number is prime
        int number = 7;
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < number - 1; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println(number + " is prime number");
        } else {
            System.out.println(number + " is not prime number");
        }
    }
}
