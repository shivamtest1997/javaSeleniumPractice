package java_Practice_Set.collection_Framework;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList :it is a class present inside java.util package which implements methods from list interface
 * LinkedList is preferred when we have frequent insertion/deletion operations.
 * every element i.e. node linked together with address
 * No shifting of element takes place,so it's faster for insertion and deletion.
 * duplicates,null are allowed
 */
public class LinkedList_3 {

    public static void main(String[] args) {
        //LinkedList ll=new LinkedList<>(); heterogeneous data
        //List ll=new LinkedList<>();
        LinkedList<Integer> ll=new LinkedList<Integer>();

        //Add elements in linked list
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        System.out.println("print linked list:"+ll);//[1, 2, 3, 4]
        System.out.println(ll.size()); //4

        //remove object from LL
        ll.remove(1); //[1,3, 4]
        System.out.println("after removing object from  LL " +ll);

        ll.add(2,55);
        System.out.println("Adding object at specific position "+ ll); // [1, 3, 55, 4]

        //retrieving object from LL
        System.out.println(ll.get(3)); //4

        System.out.println("------------using iterator------------");
        Iterator<Integer> it=ll.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        // change value
        ll.set(2, 99);
        System.out.println("After changing element into LL "+ll); //[1, 3, 99, 4]

        Collections.sort(ll);
        System.out.println("After sorting linkedList "+ll); //[1, 3, 4, 99]

        Collections.sort(ll,Collections.reverseOrder());
        System.out.println("After arranging reverse order "+ll); //[99, 4, 3, 1]

        ll.sort(Collections.reverseOrder());
        System.out.println("Another way to reverse order: "+ll);

        Collections.shuffle(ll);
        System.out.println("After shuffling elements "+ll); //[99, 3, 4, 1]

        ll.addFirst(400);
        System.out.println("Adding element as first "+ll); //[400, 99, 3, 4, 1]
        ll.addLast(600);
        System.out.println("Adding element at last "+ll); //[400, 99, 3, 4, 1, 600]

        ll.removeLast();
        System.out.println("after removing last element from linked list"+ll); //[400, 99, 3, 4, 1]
        ll.removeFirst();
        System.out.println("remove first :"+ll); //[99, 3, 4, 1]




    }

}
