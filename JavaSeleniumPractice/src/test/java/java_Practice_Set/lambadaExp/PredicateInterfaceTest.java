package java_Practice_Set.lambadaExp;
import java.util.ArrayList;
import java.util.function.Predicate;

class Employee
{
    String name;
    int salary ,experience;

    Employee(String name,int sal,int exp)
    {
        this.name=name;
        this.salary=sal;
        this.experience=exp;
    }
}


public class PredicateInterfaceTest {

    public static void main(String[] args) {

        // Predicate interface is used whenever we want to check  boolean condition in program

        // example 1
        Predicate<Integer> predicate=i->(i>10);   // i is parameter

        System.out.println(predicate.test(10)); //false
        System.out.println(predicate.test(25));  //true

        // example 2 check length of given string is greater than 4 or not

        Predicate<String> p=s->(s.length()>4);
        System.out.println(p.test("Shivam")); //  True
        System.out.println(p.test("Shiv"));   //  False

        // Example 3 Print array elements whose size is < 4 from array

        Predicate<String> p1=s->(s.length()<=4);
        String names[]={"David","Scot","Shivam","Pratik","Raj","Rasu"};
        for (String n:names)
        {
            if (p1.test(n))
            {
                System.out.println("Name whose length is less than or equals 4 is :"+n);
            }
        }

        System.out.println("---------------------------------------------------------------");

        //example 4 check employee salary >30000 and exp more than 2 years
        // predicate can take object as argument
        // obj emp-->return name if(sal>30000 exp>2

        Employee emp=new Employee("Shivam",30000,4);
        Predicate<Employee> pr=e->(e.salary>30000 && e.experience>3);
        System.out.println(pr.test(emp)); // true

        //example 5 check employee salary >30000 and exp more than 2 years

        ArrayList<Employee> al=new ArrayList<>();
        al.add(new Employee("Jhon",50000,5));
        al.add(new Employee("scot",20000,2));
        al.add(new Employee("Rasu",30000,3));
        al.add(new Employee("Priya",90000,7));

        for ( Employee e:al)
        {
            if (pr.test(e))
            {
                System.out.println(e.name+" "+e.salary);
            }
        }

        System.out.println("---------------------------------------------------------------");

        // joining predicates -- and, or , negate

        // pr1 --- checks number is even
        // pr2 --- checks greater than 50 or not

        int[] arr={5,20,55,10,60,44,111,74,19,71};

        Predicate<Integer> pr1=n->(n%2==0);
        Predicate<Integer> pr2=n->(n>50);

        for (int a:arr)
        {
         //   if (pr1.test(a) && pr2.test(a))
         //   {
         //       System.out.println(a);
         //   }

            // Another way
            if (pr1.and(pr2).test(a))
            {
                System.out.println(a);
            }
        }
        // or
        System.out.println("----Using or ----");
        for (int a:arr)
        {

            if (pr1.or(pr2).test(a))
            {
                System.out.println(a);
            }
        }


    }
}
