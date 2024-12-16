package java_Practice_Set.collection_Framework;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args) {

//        ArrayList al=new ArrayList();                        //Heterogeneous data
//        ArrayList<Integer> al1=new ArrayList<Integer>();     //Homgenious data
//        ArrayList<String> al2=new ArrayList<String>();
//        List al3=new ArrayList();

        ArrayList<Object> al=new ArrayList<Object>();

        al.add("Shivam");
        al.add(200);
        al.add('a');
        al.add(true);
        System.out.println(String.valueOf(al));
        System.out.println("Size of arraylist "+al.size());

        al.add(2, "test");
        System.out.println(String.valueOf(al));

        al.remove(4);
        System.out.println("After removing element true from arraylist "+al);

        ArrayList<String> str=new ArrayList<String>();
        str.add("Rasika");
        str.add("Pratik");
        str.add("Shubham");
        str.add("Rajeev");

        al.addAll(str);
        System.out.println("After adding collection into original arrayList :"+al);
        System.out.println("To retrieve element from third position is :"+al.get(2));

        al.set(3, 'p');
        System.out.println("Arraylist after replacing a with p :"+al);

        System.out.println("Check element Shivam present into arraylist : "+al.contains("Shivam"));

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

        //sort element of an arrayList
        Collections.sort(str);
        System.out.println(str);

        //Sort in reverse order
        str.sort(Collections.reverseOrder());
        System.out.println(str);

        // convert array to arrayList

        Double[] d =new Double[5];
        d[0]=20.5;
        d[1]=50.6;
        d[2]=0.5;
        d[3]=44.5;
        d[4]=99.5;
        for(Double dd:d)
        {
            System.out.println(dd);
        }

        ArrayList<Double> ddList=new ArrayList<Double>(Arrays.asList(d));
        System.out.println(ddList);



    }

}


