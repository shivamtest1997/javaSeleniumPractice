package java_Practice_Set.logicalPrograms.StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonNoInTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 8, 6, 7, 1, 2, 6};
        int[] arr2 = {77, 55, 4, 66, 8, 9, 2};

        // By using the for loop
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);

                }
            }
        }
        System.out.println("common integers from two array are " + list);


    }
}
