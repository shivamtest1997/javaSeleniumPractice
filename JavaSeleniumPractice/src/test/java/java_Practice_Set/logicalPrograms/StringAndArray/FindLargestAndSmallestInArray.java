package java_Practice_Set.logicalPrograms.StringAndArray;

public class FindLargestAndSmallestInArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 25, 8, 77, 65, 44, 21, 77, 4, 88, 1};
        int largest = arr[0];
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            } else if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("largest no :" + largest);
        System.out.println("smallest no :" + smallest);
    }
}

