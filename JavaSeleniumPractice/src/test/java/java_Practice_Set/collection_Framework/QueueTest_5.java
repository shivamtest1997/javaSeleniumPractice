package java_Practice_Set.collection_Framework;

import java.util.PriorityQueue;

/**
 * Queue:Group of element prior to process (FIFO)
 * Queue interface implemented by two classes PriorityQueue and linkedList
 * insertion order is preserved
 * duplicates are allowed
 * Heterogeneous data is not allowed in Priority Queue
 */
public class QueueTest_5 {
    public static void main(String[] args) {

        PriorityQueue q=new PriorityQueue();
        //adding element using add() or offer() methods

        q.add("Shivam");
        q.add("Aditya");
        q.add("Shivam");
        q.offer("Teacher");
        q.offer("Akshta");

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.element());

        q.remove("Teacher");
        System.out.println(q);

    }
}
