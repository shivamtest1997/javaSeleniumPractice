package java_Practice_Set.logicalPrograms;

public class FactorialOfNumber {
    public static void main(String[] args) {

        int a=5;
        int fact=1;
        for (int i=1;i<=a;i++)
        {
            fact=fact*i; //1 2 6 24 120
        }
        System.out.println(fact);
    }
}
