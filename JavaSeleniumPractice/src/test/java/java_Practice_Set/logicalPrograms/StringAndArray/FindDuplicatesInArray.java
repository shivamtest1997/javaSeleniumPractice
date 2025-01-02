package java_Practice_Set.logicalPrograms.StringAndArray;

import java.util.HashSet;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] arr={4,5,64,8,1,6,4,7,2,9,7,8,4};

        //set will allow to  store duplicates
        HashSet<Integer> hs=new HashSet<>();
        for (int i=0;i< arr.length;i++)
        {
            //if same integer already present it will not add to set and add method return false
            if (hs.add(arr[i])==false)
            {
                System.out.println("Duplicate no are "+arr[i]);
            }
        }
        System.out.println("Array without duplicate "+hs);

    }
}
