package java_Practice_Set;

/**
 * 1.Constructor is a block similar to method having name same as of 'class name'
 * 2.Constructor doesn't have any return type not even void
 * 3.Constructor can be called directly when we create object of class.
 * 4.we can have multiple constructor in same class.
 * 5.Constructor is used to initialize the object
 * 6.Types of constructors in java
 * 1. Default constructor
 * -When we do not create constructor in class explicitly then at the time of
 * object creation jvm will call default constructor with empty body
 * - For instance, if the class has integer fields, they will be initialized to 0;
 * for object fields, they are initialized to null.
 * 2. parameterized constructor
 * -when we create constructor with two or more parameters than it is called as parameterized
 * constructor
 * 7.Constructor overloading is possible in java.
 * 8.one constructor can be called in another constructor with the help of this() keyword
 * that is called as constructor chaining
 * 9.To call the parent class constructor we need to use super keyword
 */
class MyClass {
    int num;
    String name;


    // When we create an object of MyClass, the constructor initializes num to 0 and name to null.

    public static void main(String[] args) {
        MyClass obj = new MyClass();  // Default constructor invoked
        System.out.println(obj.num + " " + obj.name);
    }

}

public class ConstructorTest {
    String name;
    int value;
    double data;

    public ConstructorTest(String s, int b, double d) {
        this.name = s;
        this.value = b;
        this.data = d;
        System.out.println(name + "  " + value + "  " + data);

    }

    public ConstructorTest(boolean b, char c) {
        System.out.println(b + "  " + c);

    }

    public ConstructorTest() {

        this(false, 'p');
        System.out.println("this is zero argument constructor");

    }

    public static void main(String[] args) {

        ConstructorTest ct = new ConstructorTest("Shivam", 805, 44.22);//Shivam  805  44.22
        ConstructorTest ct1 = new ConstructorTest(true, 'f'); //true  f
        ConstructorTest ct2 = new ConstructorTest("Pratik", 40, 88.22);// Pratik  40  88.22

        ConstructorTest ct3 = new ConstructorTest(); //false  p
        //this is zero argument constructor

    }
}
