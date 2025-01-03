package java_Practice_Set.OPPs;

/**
 * 1.Abstract class is a class declared with abstract keyword which contains
 *   abstract methods (methods without a body) as well as complete methods.
 * 2.we can't instantiate abstract class i.e. we can't create object of abstract class.
 * 3.Concrete class is a class which provides implementation of abstract methods
 *  present in abstract class with the help of extends keyword
 * 4.if any class contains abstract method then its comparably to declare class as abstract
 *   otherwise it will show an error.
 * 5.we can have constructor inside abstract class and that can be called when we create object of child class
 * 6.we can't declare static method as abstract as we can not override static method.
 * 7.we can have static method inside abstract class but with its implementation.
 * 8.we can't use final keyword with  abstract class because final will not allow to create child class
 * 9.we can have final concrete method in abstract class but can't have final class
 * Use Case:
 *   Abstract classes are used when you have a common base class that should define a template
 *   (with some common functionality), but you want subclasses to define specific behaviors.
 */

abstract class Animal{

        abstract void sound(); //abstract class

        void eat()
        {
            System.out.println("eat method from animal class");
        }

      //  Animal a=new Animal(); this line will show an error as object creation is restricted
}
class Dog extends Animal
{
    public void sound()
    {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    // Provide implementation for the abstract method
    void sound() {
        System.out.println("Cat meows");
    }
}
public class AbstractClass {
    public static void main(String[] args) {
        // Cannot instantiate an abstract class
        // Animal animal = new Animal(); // This will give an error

        // Instantiate concrete classes
        Animal dog = new Dog();
        Animal cat = new Cat();

        // Call methods
        dog.sound();  // Output: Dog barks
        dog.eat();    // Output: This animal eats food.

        cat.sound();  // Output: Cat meows
        cat.eat();    // Output: This animal eats food.
    }
}
