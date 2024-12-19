package java_Practice_Set.logicalPrograms;

public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 121;
        int originalNumber = number;
        int reverseNumber = 0;

        while (number != 0) {
            //get the last digit
            int digit = number % 10;
            //add digit to reverse number
            reverseNumber = reverseNumber * 10 + digit;
            //remove last digit
            number = number / 10;
        }
        if (originalNumber == reverseNumber) {
            System.out.println(originalNumber + " is palindrome number");
        } else {
            System.out.println(originalNumber + " is not palindrome number");
        }
    }
}
