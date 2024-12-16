package java_Practice_Set.basics;

public class Loops_PS {
    public static void main(String[] args) {

         // Example 1
        // print below given pattern
      /*  * * * *
          * * *
          * *
          *
        */
        for (int i=4 ;i>0;i-- )
        {
            for (int j=0;j<i;j++)
            {
                System.out.print(" *");
            }
            System.out.print("\n");
        }

        //example 2
        // sum of n even numbers
        int sum=0;
        int n=4;
        for (int i=0;i<n;i++)
        {
            sum=sum+(2*i);
        }
        System.out.println(sum);

        // print table of 5
        int t=5;
        for (int i=1;i<=10;i++)
        {
            System.out.printf("%d X %d =%d\n",t ,i ,t*i);
        }
        System.out.println("--------------------------------------------");
        // print reverse table of 10
        int l=10;
        for (int i=10;i>=1;i--)
        {
            System.out.printf("%d X %d =%d\n",l ,i ,l*i);
        }
        System.out.println("--------------------------------------------");
        // find factorial of number
        int r=5;
        int fact=1;
        int h=1;
        while (h<=r)
        {
            fact *=h;
            h++;
        }
        System.out.printf("factorial of %d is %d",r,fact);
    }
}
