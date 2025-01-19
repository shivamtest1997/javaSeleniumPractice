package java_Practice_Set.collection_Framework;

import java.util.Iterator;
import java.util.Vector;

/**
 * Vector is class present inside java.util package which implements list interface
 * -Dynamic array similar to arraylist synchronized for thread safety
 * -it is legacy class
 * -use only when thread safety is required
 *
 */
public class Vector_4 {
    public static void main(String[] args) {
   //     Vector v=new Vector();  heterogeneous data

        Vector<String> vc=new Vector<>();
        vc.add("Shivam");
        vc.add("Pratik");
        vc.add("Shubham");
        vc.add("Aditya");

        System.out.println(vc); //[Shivam, Pratik, Shubham, Aditya]

        vc.add(2,"Test");
        System.out.println(vc); // [Shivam, Pratik, Test,Shubham, Aditya]

        vc.remove("Shubham");
        System.out.println(vc);  //[Shivam, Pratik, Test, Aditya]

        Iterator<String> it=vc.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
            /*
            Shivam
            Pratik
            Test
            Aditya
             */
        }
        vc.clear();
        System.out.println(vc); //[]

    }
}
