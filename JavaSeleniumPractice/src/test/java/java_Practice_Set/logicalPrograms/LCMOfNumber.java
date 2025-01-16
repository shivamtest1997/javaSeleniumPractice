package java_Practice_Set.logicalPrograms;

public class LCMOfNumber {
    public static void main(String[] args) {
        /**
         * Lcm of two or more numbers is the least positive number
         * that can be divided by both numbers
         * GCD-Greatest common divisor
         * LCM(a,b)=a*b/gcd
         *
         */
        int num1 = 12, num2 = 18;
        // find GCD using for loop
        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println("greatest common divisor of two number is :" + gcd);
        //find lcm using formula lcm=a*b/gcd
        int lcm = (num1 * num2) / gcd;
        System.out.println("LCM of two numbers is " + lcm);
    }
}
