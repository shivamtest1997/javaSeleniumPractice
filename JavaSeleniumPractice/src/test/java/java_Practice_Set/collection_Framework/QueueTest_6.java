package java_Practice_Set.collection_Framework;

import java.util.PriorityQueue;

/**
 * Queue:Group of element prior to process (FIFO)
 * Queue interface implemented by two classes PriorityQueue and linkedList
 * insertion order is preserved
 * duplicates are allowed
 * Heterogeneous data is not allowed in Priority Queue
 */
public class QueueTest_6 {
    public static void main(String[] args) {

        PriorityQueue q=new PriorityQueue();
        //adding element using add() or offer() methods

        q.add("Shivam");
        q.add("Aditya");
        q.add("Shivam");
        q.offer("Teacher");
        q.offer("Akshta");
        //q.offer(5); if we add heterogeneous data we will get ClassCastException

        System.out.println(q); //Aditya, Akshta, Shivam, Teacher, Shivam]

        // peek() and element() returns head of queue
        System.out.println(q.peek());  //Aditya
        System.out.println(q.element()); //Aditya

        q.remove("Teacher");
        System.out.println(q);

    }
}
