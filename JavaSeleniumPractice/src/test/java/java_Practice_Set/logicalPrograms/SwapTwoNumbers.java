package java_Practice_Set.logicalPrograms;

public class SwapTwoNumbers {
    public static void main(String[] args) {

        int a = 20, b = 40;

        a = a + b;  //a=60
        b = a - b;  //b=60-40=20
        a = a - b;  //a=60-20=40

        System.out.println(a + " " + b);

        int p = 20, q = 40;
        int t;
        t = p; //20
        p = q; //40
        q = t; // 20
        System.out.println(p + " " + q);


    }
}
