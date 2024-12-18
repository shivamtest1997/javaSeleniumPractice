package java_Practice_Set.logicalPrograms;
public class ArmstrongNumberProgram {
    /**
     * An Armstrong number is a number that is equal to the sum of its digits,
     * each raised to the power of the number of digits in the number
     * Explanation: For example, 153 is an Armstrong number
     * because (1^{3}+5^{3}+3^{3}=153)
     */
    public static void main(String[] args) {
        int number = 153;
        int originalNumber = number;
        int sum = 0;
        //calculate sum of the cubes of each digit
        while (number != 0) {
            //extract the last digit
            int digit = number % 10;
            //cube the digit and add it to sum
            sum += digit * digit * digit;

            number = number / 10; //remove last digit
        }
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is armstrong number");
        } else {
            System.out.println(originalNumber + " is not armstrong number");
        }

    }
}
