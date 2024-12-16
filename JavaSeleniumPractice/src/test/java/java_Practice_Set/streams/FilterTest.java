package java_Practice_Set.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {

        ArrayList<Integer> number=new ArrayList<Integer>();

        number.add(10);
        number.add(20);
        number.add(25);
        number.add(30);

        // this is one way to create Arraylist and stored data in collection

        List<Integer> numList= Arrays.asList(10,20,30,25,45);

        // filter numList

        List<Integer> evenNumList=new ArrayList<Integer>();

        // without using streams
        for (int n:numList)
        {
            if (n%2==0)
            {
                evenNumList.add(n);
            }
        }
        System.out.println("After filtering numList without streams :  "+evenNumList);

      // using streams

        evenNumList=numList.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println("After applying streams concept : "+ evenNumList);

        // for each after filtering directly print list in console without storing it in another collection
        numList.stream().filter(n->n%2==0).forEach(n-> System.out.println(n));


        // Example 2

        List<String> names=Arrays.asList("scott","Pratik","ram","Rajeev","Neha");

        List<String> longNames=new ArrayList<>();

        longNames=names.stream().filter(s->s.length()>4 && s.length()<8).collect(Collectors.toList());

        System.out.println(longNames);

        // Example 3

        List<String> words=Arrays.asList("Hello","Test","sky",null,"tea",null);

        List<String> result=new ArrayList<>();

        // remove nulls from words and print result

        result=words.stream().filter(s->s!=null).collect(Collectors.toList());
        System.out.println(result);


    }
}
