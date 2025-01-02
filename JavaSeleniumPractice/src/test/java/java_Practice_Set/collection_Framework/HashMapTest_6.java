package java_Practice_Set.collection_Framework;

import java.util.HashMap;
import java.util.Map;

/**
 * In Map we can store data in key-value pair
 * Map Interface implemented by two classes HashMap and HashTable
 * every key-value pair is called as entry so map is also called as collection of entries.
 * put(key,value) -->to add data
 * get(key) -->to retrieve data from map
 * remove(key)-->to remove data from map
 * containsKey(key) --to check key is present
 * containsValue(value)--to check value is present.
 * keySet()--return keys in set
 * values()--return collection of values
 *
 */
public class HashMapTest_6 {
    public static void main(String[] args) {

        HashMap<Integer,String> hm=new HashMap<Integer,String>();

        hm.put(101, "Shivam");
        hm.put(102, "David");
        hm.put(103, "scot");
        hm.put(104, "Marry");
        hm.put(105, "David");
        hm.put(102, "Sachin"); //Duplicate keys are not allowed here 102 replaced as Sachin

        System.out.println(hm);
        System.out.println("Get data from map "+hm.get(104));
        hm.remove(104);
        System.out.println("Map after removing object : "+hm);
        System.out.println(hm.containsKey(101));
        System.out.println(hm.containsValue("Marry"));

        System.out.println("check for map is empty or not : "+hm.isEmpty());

        System.out.println("Retrieving keys from Map"); // Return keys in set format
        System.out.println(hm.keySet());

        System.out.println("Retrieving values from Map");
        System.out.println(hm.values()); // returns as collection

        System.out.println("Retrieving Entry set");
        System.out.println(hm.entrySet()); // returns all entries as set object

        for (int keys:hm.keySet())
        {
            System.out.println(keys);
        }
        for (Object value:hm.values())
        {
            System.out.println(value);
        }

        // Retrieving entries side by side
        for (int i:hm.keySet())
        {
            System.out.println(i+" "+hm.get(i));
        }

        // Entry Methods ************
        System.out.println("*************************************");
        for (Map.Entry e:hm.entrySet())
        {
            System.out.println(e.getKey()+" "+e.getValue());
        }

    }
}
