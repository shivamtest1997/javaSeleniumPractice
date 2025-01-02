package java_Practice_Set.collection_Framework;

import java.util.HashSet;

/**
 * HashSet: it is a class present inside java.util package which implements methods from Set interface
 * Duplicates are not allowed
 * insertion order is not preserved
 * default initial size is 16
 */
public class HashSetTest_4 {
    public static void main(String[] args) {

        HashSet hs=new HashSet();  /// default capacity 16 and LF(Load Factor)/fill ratio is 0.75
        HashSet hs1=new HashSet(100);  // initial capacity is 100
        HashSet hs2=new HashSet(100,(float)0.90);  //initial capacity is 100 and LF is 0.90

        HashSet<String> hs3=new HashSet<String>();

        // Add elements into hashset

        hs.add("Shivam");
        hs.add(100);
        hs.add(0.25);
        hs.add(true);
        hs.add('A');
        hs.add(null);
        hs.add("Shivam");    // Duplicates are not allowed hence it will ignore
        hs.add(100);        // Duplicates are not allowed hence it will ignore

        System.out.println(hs);

        hs1.add("Test1");
        hs1.add("Rajeev");
        hs1.add("Pavan");

        // add another collection to hs
        hs.addAll(hs1);

        System.out.println("After adding collection : "+hs);

        //remove
        hs.remove("Test1");
        System.out.println(hs.contains("Test1"));


        System.out.println( ("Retrieving the data ............"));

        for (Object h:hs)
        {
            System.out.println(h);
        }

        hs.removeAll(hs1);
        System.out.println("After removing collection from hs : "+hs);



    }
}
