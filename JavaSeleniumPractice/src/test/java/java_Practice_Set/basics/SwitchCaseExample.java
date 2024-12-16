package java_Practice_Set.basics;
import java.util.Scanner;
public class SwitchCaseExample {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int age= sc.nextInt();
        switch (age)
        {
            case 18:
                System.out.println("You are eligible for vote");
                break;
            case 23:
                System.out.println("you are eligible for marriage");
                 break;
            default:
                System.out.println("Enjoy your life");
        }
     }
}
