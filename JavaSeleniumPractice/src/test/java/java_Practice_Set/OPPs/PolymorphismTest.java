package java_Practice_Set.OPPs;

/**
 * Polymorphism : Polymorphism is a latin word where poly stands for 'many' and morphism stands for 'form'
 * i.e. ability of an object to take on many forms
 * In java polymorphism are classified into 2types:
 *                  1. Compile time polymorphism
 *                  2. Runtime polymorphism
 * 1.Compile time polymorphism:
 *    -In compile time polymorphism method declaration is going to get bind with its implementation at compile time
 *      based on arguments known as compile time polymorphism
 *    -As binding takes place during compile time only so it is known as early binding.
 *    -It is also known as static binding
 *    -Compile time polymorphism is achieved by 'Method Overloading'.
 *
 * Method Overloading :
 *    -Method having same name but different arguments within the same class called as overloading.
 *    -method overloading is applicable for any type of method like static,main,non-static and even constructor as well.
 *    - same name,Within Same class but different arguments.
 *
 * 2.Runtime Polymorphism:
 *      -In runtime polymorphism method declaration is going to get bind with its implementation at runtime based on
 *       object creation is known as runtime polymorphism.
 *      -As binding take place at runtime/execution so it is 'late binding'
 *      -It is also known as dynamic binding
 *      -runtime polymorphism is achieved by 'Method Overriding'
 *
 * Method Overriding:
 *      -Getting superclass method into subclass with the help of extends keyword & changing its implementation
 *       according to subclass specification is called as method overriding.
 *      -Method having same name+same arguments+different class
 *      -The method in the subclass must have the same name, return type, and parameters as the one in the superclass.
 */

/**
 * Method overloading :
 */
class Calculator {
    // Overloaded method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(10, 20)); // returns 30
        System.out.println(c.add(10, 20, 30)); //return 60
        System.out.println(c.add(5.5, 5)); //return 10.5
    }
}


/**
 * Method Overriding:
 */
class Parent {
    // Method in superclass
    public void greet() {
        System.out.println("Hi Good Morning");
    }
    final public void finalMethod()
    {
        System.out.println("final method from parent class");
    }
    public void extraParent()
    {
        System.out.println("extra method from parent class");
    }
}

class Child1 extends Parent {
    // Overriding the sound method in subclass
    public void greet() {
        System.out.println("Hello from child one");
    }
   /* public void finalMethod()   //we can't override final method in java
    {

    }*/
}

class Child2 extends Parent {
    // Overriding the sound method in subclass
    public void greet() {
        System.out.println("Hello from child 2");
    }
    public void extraChild2()
    {
        System.out.println("extra method from child 2 class");
    }

}

public class PolymorphismTest {

    public static void main(String[] args) {
        Parent p = new Parent();
        p.greet(); // parent class method // Hi Good Morning

        Parent p1 = new Child1();
        p1.greet(); //child1 class method // Hello from child one

        Child1 c1=new Child1();
        c1.greet(); //child1 class method //Hello from child one

        Child2 c2=new Child2();
        c2.greet(); //child 2 class method //Hello from child 2

        Parent p2=new Child2();
        p2.greet(); // parent class method //  Hello from child one
        p2.extraParent(); //extra method from parent class
      //  p2.extraChild2();  by using parent reference we won't be able to call child2 class method

    }

}
