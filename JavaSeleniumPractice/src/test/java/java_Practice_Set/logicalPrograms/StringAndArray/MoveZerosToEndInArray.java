package java_Practice_Set.logicalPrograms.StringAndArray;

import java.util.Arrays;

public class MoveZerosToEndInArray {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1};

        int[] output = new int[arr.length];
        int index = 0;
        for (int a : arr) {
            if (a == 1) {
                output[index++] = 1;
            }
        }
        System.out.println(Arrays.toString(output));

    }
}
