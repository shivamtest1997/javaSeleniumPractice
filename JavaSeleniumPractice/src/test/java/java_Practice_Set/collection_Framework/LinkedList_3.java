package java_Practice_Set.collection_Framework;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList :it is a class present inside java.util package which implements methods from list interface
 * LinkedList is preferred when we have frequent insertion/deletion operations.
 * every element i.e. node linked together with address
 * No shifting of element takes place so its faster for insertion and deletion.
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

        System.out.println("print linked list:"+ll);
        System.out.println(ll.size());

        //remove object from LL
        ll.remove(1);
        System.out.println("after removing object from  LL " +ll);

        ll.add(2,55);
        System.out.println("Adding object at specific position "+ ll);

        //retrieving object from LL
        System.out.println(ll.get(3));
        Iterator<Integer> it=ll.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        // change value
        ll.set(2, 99);
        System.out.println("After changing element into LL "+ll);

        Collections.sort(ll);
        System.out.println("After sorting linkedList "+ll);

        Collections.sort(ll,Collections.reverseOrder());
        System.out.println("After arranging reverse order "+ll);
        ll.sort(Collections.reverseOrder());
        System.out.println("Another way to reverse order: "+ll);
        Collections.shuffle(ll);
        System.out.println("After shuffling elements "+ll);

        ll.addFirst(400);
        System.out.println("Adding element as first "+ll);
        ll.addLast(600);
        System.out.println("Adding element at last "+ll);

        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println("remove first :"+ll);




    }

}
