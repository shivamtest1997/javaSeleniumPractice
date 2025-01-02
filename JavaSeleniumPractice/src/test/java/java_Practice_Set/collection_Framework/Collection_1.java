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
 *  5.Collections is class in java from java.util package which contains method like sort()
 *  Collections.sort()--->we can sort given array list using this method
 */

/**
 *              Collection(I)
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
 * Map(I) : Map is an interface which represents elements in key-value pair,where key should not be duplicated but values can be.
 * Map(I) ---implemented by -->HashMap(C)---extends-->LinkedHashMap(C)
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
