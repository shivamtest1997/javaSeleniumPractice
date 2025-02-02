package java_Practice_Set.collection_Framework;

/**
 * 1.Collection :a group of object represented by a single entity is called as collection.
 *   Collection is an interface in java
 *
 * 2.For representing a group of object instead of creating multiple variable we have a single entity
 * i.e. array example : int a[]=new int[5]; String[] s={"Shivam","Test"};
 *
 * 3.But in Array we can store homogeneous data only i.e. String[] store only String type of data
 * it will not store data of other dataTypes
 *
 * 4.To store heterogeneous data we can create Object array
 *  Object[] obj =new Object[10];
 *  It also has some limitations:
 *     -it has a fixed size we can't store more than 10 elements
 *      otherwise it will throw an exception ArrayIndexOutOfBoundException.
 *     -It is not growable in nature.
 *     -data Structure i.e. ready-made method are not available like add(),sort()
 *  5.Collections is the class in java from java.util package which contains method like sort()
 *  Collections.sort()--->we can sort given array list using this method
 */

/**
 *                    Collection(I)
 *------------------------------------------------------
 *   List(I)               Set(I)           Queue(I)
 * -----------        --------------     -------------
 * 1.ArrayList(C)     1.HashSet(C)        1.priorityQueue(C)
 * 2.LinkedList(C)    2.LinkedHashSet     2.LinkedList(C)
 * 3.Vector(C)
 *
 * List : List is child interface of collection
 *        List is used to store group of elements in sorted order
 *        Insertion order is preserved and duplicates are allowed
 *
 * Set: Set is child interface of collection
 *      insertion order is not preserved
 *      duplicated are not allowed in set
 *      only one null value is allow
 *
 * Queue: Queue is child interface of collection
 *        whenever we want elements prior to process FIFO(first in first out) one after another
 *
 * Map(I) : Map is an interface which represents elements in key-value pair,where key should not
 * be duplicated but values can be.
 * Map(I) ---implemented by -->HashMap(C),linkedHashMap(c),TreeMap(c),HashTable(c)
 *
 */

/*
    ArrayList                     LinkedList                              Vector

  1.uses a dynamic array for   1.Uses doubly linked list           1.uses dynamic array for storage
    storage                     for storage                         synchronized for thread safety

  2.Fast for accessing elements 2.slower for accessing elements   2.Fast for accessing elements
   by index                      as traversal is required            by index

  3.insertion and deletion      3.insertion and deletion are      3.insertion and deletion slower
   is slower as shifting is     faster as only pointers are         similar to arraylist as shifting
   to be needed after the       adjusted                            is required
   modified position

  4.Not Thread safe             4.Not thread safe                4.Thread safe due to synchronized
                                                                   methods but less efficient

  5.suitable for applications   5.suitable for application       5.suitable for multithreaded
  where frequent retrieval is     where insertion or deletion      environments where thread safety
   required.                      is required.                     is required

  6.Increases its size by 50%  6.Does not use resizing           6.Increase its size by double when
    when full.                    mechanism.                       full.
 */

/**
 *       HashMap                                   HashTable
 * 1.Not Thread safe,suitable              1.Thread safe as all methods are synchronized
 *  for single threaded applications        suitable for multithreaded applications
 *
 * 2.faster due to no synchronization     2.slower due to synchronization overhead
 *
 * 3.Allow one null key and multiple      3.Does not allow null keys or null values
 *  null values.
 *
 * 4.Modern and preferred for most use   4.considered legacy rarely used in new use case
 * case
 */

/**
 * Method is collection:
 * 1.add(Object);
 * 2.addAll(Collection);
 * 3.remove(Object);
 * 4.removeAll(Collection);
 * 5.retainAll(Collection); -->except this collection all other elements are removed
 * 6.clear(); ---to clear all elements
 * 7.isEmpty(); --return true or false
 * 8.size();
 * 9.contains(Object);
 * 10.containsAll(Collection);
 * 11.collection.toArray()--to convert collection to array
 */

/**
 *List : apart from collection methods list is having some own methods
 * 1.add(index,object);
 * 2.addAll(index,Collection);
 * 3.remove(index);
 * 4.get(index);
 * 5.set(4,object); --to replace element from 5th position
 */
public class Collection_1 {
}
