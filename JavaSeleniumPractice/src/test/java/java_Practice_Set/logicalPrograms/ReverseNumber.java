package java_Practice_Set.logicalPrograms;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1234;
        int rev = 0;

        while (num != 0) {
            // extract the last digit
            int digit = num % 10;             // 4  3  2 1
            // Add digit to reverse number
            rev = rev * 10 + digit;           // 4   43 432 4321
            // remove last digit
            num = num / 10;                  // 123  12  1 0
        }
        System.out.println(rev);
    }
}
