package java_Practice_Set.logicalPrograms;

public class LeapYear {
    public static void main(String[] args) {
        int year=2024;
        // year which is divisible by 4 and not divisible by 100 or divisible by 400
        if( (year%4==0 && year%100!=0)|| year%400==0)
        {
            System.out.println(year+" is a leap year");
        }
        else {
            System.out.println(year+" is not leap year");
        }
    }
}
