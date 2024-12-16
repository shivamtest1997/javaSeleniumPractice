package java_Practice_Set.basics;
import java.util.*;
public class Arrays_PS {
    public static void main(String[] args) {

        // 1. create float array of 5 elements and its sum
        float[] marks = {10.5f, 22.5f, 66.3f, 1.5f, 5.5f};
        float sum=0;
        for (float element:marks)
        {
            sum=sum+element;
        }
        System.out.println("sum of all elements in array is "+sum);
        System.out.println("Average of marks "+sum/marks.length);
        System.out.println("-----------------------------------");

        // 2. find whether number present into array or not
        int[] numbers= new int[5];
        numbers[0]=5;
        numbers[1]=7;
        numbers[2]=55;
        numbers[3]=66;
        numbers[4]=70;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number to find in array");
        int isNum=sc.nextInt();
        //int isNum=66;
        boolean isArray=false;
        for (int element:numbers)
        {
            if (isNum==element)
            {
                isArray=true;
                break;
            }
        }
        if (isArray)
        {
            System.out.printf("%d  is present into array",isNum);
        }
        else
        {
            System.out.printf("%d  is not present into array",isNum);

        }
        System.out.println("-----------------------------------");

        //3. create two matrix and result sum of two matrices
        int[][] mat1= { {0,1,2},
                        {3,4,5}
                      };
        int[][] mat2= { {4,5,6},
                        {7,8,9}
                      };

        int[][] result= { {0,0,0},
                          {0,0,0}
                      };
        for (int i=0;i< mat1.length;i++)
        {
            for (int j=0;j<mat1[i].length;j++)
            {
                result[i][j]=mat1[i][j]+mat2[i][j];
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }

        //4. find out maximum element in array
        int[] arr={100,-50,-600,200,40,50,-300};
        int maxValue=Integer.MIN_VALUE;
        for (int e:arr)
        {
            if (e>maxValue)
            {
                maxValue=e;
            }
        }
        System.out.println("maximum value in array is "+maxValue);

        // verify array is sorted or not
        int[] arr1={1,2,2,3,8,6};
        boolean isSorted=true;
        for (int i=0;i< arr1.length-1;i++){
            if (arr1[i]>arr1[i+1])
            {
                isSorted=false;
                break;
            }
        }
        if (isSorted)
        {
            System.out.println("Array is sorted");
        }
        else {
            System.out.println("Array is not sorted");
        }

    }
}
