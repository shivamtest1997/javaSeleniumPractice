package java_Practice_Set.collection_Framework;


import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * it is a class present inside java.util package which implements methods from set interface
 * duplicates are not allowed
 * insertion order is preserved.
 * Sorting and shuffling is not possible in HashSet and LinkedHashSet.
 */
public class LinkedHashSetTest_5 {
    public static void main(String[] args) {

        LinkedHashSet<Integer> hs=new LinkedHashSet<Integer>();
        hs.add(5);
        hs.add(20);
        hs.add(40);
        hs.add(60);
        hs.add(70);
        System.out.println(hs); //[5, 20, 40, 60, 70]

        hs.add(100);
        hs.add(500);
        System.out.println(hs); //[5, 20, 40, 60, 70, 100, 500]

        hs.remove(100);
        System.out.println("After removing element from set "+hs); //[5, 20, 40, 60, 70, 500]

        for (Object obj:hs)
        {
            System.out.println(obj);
        }
        System.out.println("--------------------------");

        Iterator it=hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }




    }
}
