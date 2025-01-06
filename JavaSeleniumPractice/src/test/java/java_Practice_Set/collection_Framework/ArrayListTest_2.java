package java_Practice_Set.collection_Framework;

import java.util.*;

/**
 * ArrayList :it is a class present inside java.util package which implements methods from list interface
 * Features:
 *  ArrayList is growable in nature
 *  Insertion order is preserved
 *  By default capacity is 10
 *  duplicates are allowed
 * Use : ArrayList is preferred for frequent getting(Retrieve) operations
 */
public class ArrayListTest_2 {

    public static void main(String[] args) {
        //ways to create ArrayList Object

//        ArrayList al=new ArrayList();                        //Heterogeneous data
//        ArrayList<Integer> al1=new ArrayList<Integer>();     //Homgenious data
//        ArrayList<String> al2=new ArrayList<String>();
//        List al3=new ArrayList();

        ArrayList al=new ArrayList(); //for storing Heterogeneous data

        al.add("Shivam");
        al.add(200);
        al.add('a');
        al.add(true);
        System.out.println(al); //[Shivam, 200, a, true]
        System.out.println("Size of arraylist "+al.size()); //4

        al.add(2, "test");
        System.out.println("Arraylist After adding element at index position :"+al);//[Shivam, 200, test, a, true]

        al.remove(4);
        System.out.println("After removing element from arraylist "+al);//[Shivam, 200, test, a]

        ArrayList<String> str=new ArrayList<String>(); //To store homogeneous data
        str.add("Rasika");
        str.add("Pratik");
        str.add("Shubham");
        str.add("Rajeev");

        al.addAll(str); // to store one collection to other
        System.out.println("After adding collection into original arrayList :"+al);//[Shivam, 200, test, a, Rasika, Pratik, Shubham, Rajeev]
        System.out.println("To retrieve element from third position is :"+al.get(2)); //test

        al.set(3, 'p');
        System.out.println("Arraylist after replacing a with p :"+al); //[Shivam, 200, test, p, Rasika, Pratik, Shubham, Rajeev]

        System.out.println("Check element Shivam present into arraylist : "+al.contains("Shivam")); //true

        // Reading the data using different ways

        // 1. Using for loop
        for(int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i));
        }
        System.out.println("-----------------------------------------------------");

        // 2. For each loop
        for (Object obj:al)
        {
            System.out.println(obj);
        }
        System.out.println("-----------------------------------------------------");

        // 3.Iterator

        Iterator<Object> it=al.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("-----------------------------------------------------");

        //sort element of an arrayList
        Collections.sort(str);
        System.out.println(str); //[Pratik, Rajeev, Rasika, Shubham]

        //Sort in reverse order
        str.sort(Collections.reverseOrder());
        System.out.println(str); //[Shubham, Rasika, Rajeev, Pratik]

        Collections.sort(str,Collections.reverseOrder());
        System.out.println("Another way to use reverseOrder "+str); // [Shubham, Rasika, Rajeev, Pratik]


        // convert array to arrayList use method Arrays.asList(arr);

        Double[] d =new Double[5];
        d[0]=20.5;
        d[1]=50.6;
        d[2]=0.5;
        d[3]=44.5;
        d[4]=99.5;
        System.out.println("---------print Array---------");
        for(Double dd:d)
        {
            System.out.println(dd);
        }

        System.out.println("-------print arraylist----");
        ArrayList<Double> ddList=new ArrayList<Double>(Arrays.asList(d));
        ddList.add(10.5);
        ddList.add(4,5.5);
        System.out.println(ddList);

        System.out.println("-------Convert Arraylist to Array----");
        Object[] ddArr=ddList.toArray();
        for(Object ob:ddArr) {
            System.out.println(ob);
        }
        System.out.println("another way of printing array : "+Arrays.toString(ddArr));//[20.5, 50.6, 0.5, 44.5, 5.5, 99.5, 10.5]

    }

}


