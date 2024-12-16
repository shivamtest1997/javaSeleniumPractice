package java_Practice_Set.logicalPrograms;

import java.util.Scanner;

public class GreaterOfThreeNumbers {
    public static void main(String[] args) {
        // Take three numbers from user and identify which number is greater
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number");
        int a=sc.nextInt();

        System.out.println("Enter second number");
        int b= sc.nextInt();

        System.out.println("Enter third number");
        int c=sc.nextInt();

        if (a>b&& a>c)
        {
            System.out.println("a is greater number");
        }
        else if (b>a && b>c)
        {
            System.out.println("b is greater number");
        }
        else
        {
            System.out.println("C is greater number");
        }
    }
}
