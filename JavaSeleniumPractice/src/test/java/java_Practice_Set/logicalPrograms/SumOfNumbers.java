package java_Practice_Set.logicalPrograms;

public class SumOfNumbers {
    public static void main(String[] args) {
        /**
         * for printing sum of numbers 1 to 10
         * sum += is logic used to print sum of all numbers
         */
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i; // add each number to sum
        }
        System.out.println("The sum of numbers 1 to 10 is " + sum);
    }
}
