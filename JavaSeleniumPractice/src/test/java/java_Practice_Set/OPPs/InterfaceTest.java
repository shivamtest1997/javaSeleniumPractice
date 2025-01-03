package java_Practice_Set.OPPs;
/**
 * Interface:Interface is basically a blueprint of a class which contains variables and methods
 * 1.Interface is 100% abstract in nature
 * 2.Methods in interface are by default public and abstract Hence when we are implementing method in class
 *      we need to declare it as public else it will throw an error.
 * 3.variables declared in interface are by default public,static and final whether we declare it or not
 *      to access variables in class we can call it by Interface.variableName
 * 4.interface will not have constructor it will throw error if we try to create it
 * 5.interface contains default methods along with static methods with its complete implementation.
 *      static methods can be called directly  by Interface.methodName in class.
 * 6.we can't create object of interface, we can create object reference.
 * 7.we need to create implementation class to implements all abstract methods of interface
 * 8.interface support multiple inheritance
 * 9.if a class is not able to provide implementation of all the methods of interface then
 *      we need to declare class as abstract class
 * 10.we use extends keyword to establish parent and child relationship between two interfaces,
 *      but we should use 'implements' keyword in order to connect interface and implementation class
 * 11.we can extends multiple interface at a time by another interface
 * 12.A class can extends another class and implements on interface at sametime
 * 13.if two interface contains same method name in it then implementation class has to implement them
 *      single time as name of methods are same and abstract in nature
 */

//Interface
interface Shape {
    int length = 10; //by default final and static
    int width = 20; //by default final and static

//    Shape()  this will throw an error as constructor is not allowed
//    {
//
//    }
    void circle(); //abstract method

    default void square() {
        System.out.println("This is square default method from interface");
    }

    static void rectangle() {
        System.out.println("This is static rectangle method from interface");
    }

}

//Class
class Circle implements Shape
{

    public void circle()
    {
        System.out.println("This is circle abstract method");
    }
    void  triangle()
    {
        System.out.println("Triangle method from circle class");
    }

        public static void main(String[] args) {
            Circle c=new Circle();

            //Shape.length=40 this is invalid we can't update variable as it is final
            //Shape.width accessible directly using Interface.variableName because static in nature

            c.circle(); //abstract method
            c.square(); //default method
            Shape.rectangle(); //static method can directly access from interface
            c.triangle(); //method from class

            // Shape sh=new Shape(); invalid statement interface can't be instantiated

            Shape sh=new Circle(); //we can create reference variable of interface
            sh.circle(); //abstract method from interface
            sh.square(); //default method
         // sh.triangle(); we can't access class methods through interface reference
            System.out.println("Area of shape: "+Shape.length*Shape.width);
        }

}

//Interface
interface Formula{
    String s="Shivam";
    double d=10.5;
    void area();
}

// multiple inheritance
class Maths implements Shape,Formula{

    public void circle()
    {
        System.out.println("circle abstract method from Shape Interface");
    }
    public void area()
    {
        System.out.println("area abstract method from Area interface");
    }

    public static void main(String[] args) {
        Maths m=new Maths();
        m.area();
        m.circle();
    }
}
interface Test extends Formula,Shape {
        void circle();
        void area();
        default void square() {
            Shape.super.square(); //if went to call same method
            System.out.println("default method");
        }
}

// class not able to implements all methods from interface then we need to declare it as abstract
abstract class A implements Shape,Formula{

    public void circle() {

    }
}
public class InterfaceTest {

}