package java_Practice_Set.collection_Framework;


import java.util.LinkedHashSet;

/**
 * it is a class present inside java.util package which implements methods from set interface
 * duplicated are not allowed
 * insertion order is preserved.
 * Sorting and shuffling is not possible in HashSet and LinkedHashSet.
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {

        LinkedHashSet<Integer> hs=new LinkedHashSet<Integer>();
        hs.add(5);
        hs.add(20);
        hs.add(40);
        hs.add(60);
        hs.add(70);
        System.out.println(hs);



    }
}
