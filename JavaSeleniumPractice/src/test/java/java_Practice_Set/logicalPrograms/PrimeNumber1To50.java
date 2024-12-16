package java_Practice_Set.logicalPrograms;

public class PrimeNumber1To50 {
    public static void main(String[] args) {
        //Iterate through numbers 2-50 since 1 is not prime number
        for (int num = 2; num <= 50; num++) {
            boolean isPrime = true;
            //check num is divisible by any number between 2 to num-1
            for (int j = 2; j < num; j++) {

                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("prime numbers are " + num);
            }

        }
    }
}
