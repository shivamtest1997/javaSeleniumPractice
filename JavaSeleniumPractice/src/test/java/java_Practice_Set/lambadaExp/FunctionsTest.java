package java_Practice_Set.lambadaExp;

import java.util.ArrayList;
import java.util.function.Function;

class Emp
{
    String name;
    int salary;
    Emp(String names,int sal)
    {
        this.name=names;
        this.salary=sal;
    }

}


public class FunctionsTest {
    public static void main(String[] args) {

        //whenever we want to pass some 'type' and return some value then we go for functions

        Function<Integer,Integer> f=n->n*n;

        System.out.println(f.apply(5)); //25
        System.out.println(f.apply(2)); //4
        System.out.println(f.apply(6)); //36

        // pass String and find string length and return output as integer

        Function<String,Integer> f1=s -> s.length();

        System.out.println(f1.apply("Shivam"));  //6
        System.out.println(f1.apply("Welcome"));  //7


        // Example--> Pass Emp as argument and return salary with bonus

      ArrayList<Emp> al=new ArrayList<Emp>();
      al.add(new Emp("Rasika",15000));
      al.add(new Emp("Pratik",60000));
      al.add(new Emp("Jhon",90000));

     Function<Emp,Integer> fe=e-> {
                                         int sa = e.salary;
                                         if (sa >= 10000 && sa <= 15000)
                                             return (sa * 10 / 100);
                                         else if (sa > 15000 && sa <= 30000)
                                             return (sa * 20 / 100);
                                         else if (sa > 30000)
                                             return (sa * 30 / 100);
                                             return 0;
                                        };
     for (Emp emp:al)
     {
         int bonus=fe.apply(emp);
         emp.salary= emp.salary+bonus;
         System.out.println("updated salary of "+emp.name+" with bonus of " +bonus+ " is "+emp.salary);
     }

     }



    }