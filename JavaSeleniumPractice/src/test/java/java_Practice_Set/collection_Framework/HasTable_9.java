package java_Practice_Set.collection_Framework;

import java.util.HashMap;
import java.util.Hashtable;

public class HasTable_9 {
    public static void main(String[] args) {
        Hashtable<Integer,String> ht=new Hashtable<>();

        ht.put(101, "Shivam");
        ht.put(102, "David");
        ht.put(103, "scot");
        ht.put(104, "Marry");
        ht.put(105, "David");
        ht.put(102, "Sachin"); //Duplicate keys are not allowed here 102 replaced as Sachin

        System.out.println(ht);
    }
}
