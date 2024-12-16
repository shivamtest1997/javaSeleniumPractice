package java_Practice_Set.lambadaExp;

// Declare functional interface which contains only one abstract method
// FI also contains default methods as well
@FunctionalInterface
interface Cab1 {
    public void bookCab();

    default void test()
    {
        System.out.println("I am default method of functional interface");
    }
}

 // We don't require concrete class to implement FI method


public class Test1
{
    public static void main(String[] args) {

        Cab1 cab1=()-> System.out.println("Ola Cab is booked");
        cab1.bookCab();

    }
}


