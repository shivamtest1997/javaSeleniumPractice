package java_Practice_Set.logicalPrograms;

public class SwapTwoNumbers {
    public static void main(String[] args) {

        int a = 20, b = 40;

        // 1. Swap using third variable
        int temp;
        temp=a;
        a=b;
        b=temp;
        System.out.println("After swapping numbers a is "+a+" and b is "+b);

        a=20;
        b=40;
        // 2.Swap using two variable
        a=a+b; //60
        b=a-b; //20
        a=a-b; //40

        System.out.println("After swapping two numbers a is "+a+" and b is "+b);

        a=20;
        b=40;
        // 3.Swap using XoR operator
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("After swapping two numbers a is "+a+" and b is "+b);


    }
}
