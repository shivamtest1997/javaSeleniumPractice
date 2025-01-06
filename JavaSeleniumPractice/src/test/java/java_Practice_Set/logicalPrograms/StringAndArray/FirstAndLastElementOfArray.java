package java_Practice_Set.logicalPrograms.StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FirstAndLastElementOfArray {

    public static void main(String[] args) {
        Integer[] arr={11,4,5,6,7,8,9,2};

        ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(arr));

        System.out.println(list.get(0)); //first element
        System.out.println(list.get(arr.length-1)); // last element

        // print second largest and second smallest
        Collections.sort(list);
        System.out.println(list);
        System.out.println("second smallest "+list.get(1));
        System.out.println("second largest "+list.get(arr.length-2));
    }
}
