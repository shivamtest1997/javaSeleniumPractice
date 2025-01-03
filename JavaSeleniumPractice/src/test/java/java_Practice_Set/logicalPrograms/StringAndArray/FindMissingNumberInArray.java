package java_Practice_Set.logicalPrograms.StringAndArray;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        /**
         * 1. Calculate A=n(n+1)/2 where n is the largest no from array
         * 2.Calculate B=sum of all numbers in series
         * 3.missing number =A-B
         */
        int largestNo = 8;
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int a = largestNo * (largestNo + 1) / 2;
        System.out.println("missing no is " + (a - sum));
    }
}
