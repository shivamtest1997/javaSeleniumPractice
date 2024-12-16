package java_Practice_Set.collection_Framework;

import java.util.PriorityQueue;

public class QueueTest {
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
