package java_Practice_Set.OPPs;

/**
 * 1.Inheritance is one of the oops principle where one class acquires properties of another class
 * with the help of extends keyword.
 * 2.The class from which properties are inherited called as super/base/parent class
 * 3.The  class which acquires these properties is called as sub/child/ class
 * 4.Inheritance take place between two or more classes
 * 5.There are multiple type of inheritance in java
 *    1.Single Inheritance: If a class acquires properties of only one super class with the help of
 *      extends keyword then it referred as single inheritance
 *    2.Multilevel Inheritance- If a class acquired properties of one super class and that super class
 *      also acquired properties of another super class and phenomenon continue  called as multilevel inheritance
 *    3.Hierarchical Inheritance- when multiple classes acquired properties of only one parent class then it is called
 *      as hierarchical inheritance
 *    4.Multiple Inheritance-if one subclass acquired properties of two or more super classes then it is called
 *     as multiple inheritance but java doesn't support multiple inheritance for classes because of "Diamond  Ambiguity"
 *     problem
 * 6. Through inheritance, we achieve repeatability,reusability.
 * 7. While constructors are not inherited in Java, a subclass can invoke the constructor of the superclass using the super keyword.
 */

class Father
{
    int rupee;
    void money(int rupee)
    {
        System.out.println("money method from parent class "+rupee);
    }
    void car()
    {
        System.out.println("car method from parent class");
    }
    Father()
    {
        System.out.println("constructor from parent class");
    }

}

class Children extends  Father{
    void mobile()
    {
        System.out.println("Mobile method from child class");
    }

    @Override
    void money(int rupee) {
        super.money(rupee);
    }
}
class GrandChildren extends Children {
    void sms()
    {
        System.out.println("sms method from grandchildren class");
    }
}
class GrandChildren2 extends Children{
    void whatsApp()
    {
        System.out.println("whats app method from grandchildren 2");
    }
    void useOfSuper()
    {
        super.rupee=40;
        System.out.println(rupee);
    }
    GrandChildren2()
    {
        super();
    }
}
public class Inheritance {
    public static void main(String[] args) {
        // single inheritance -
        Children c=new Children(); //constructor from parent class
        c.money(50); // money method from parent class 50
        c.mobile();        // Mobile method from child class

        // multilevel inheritance
        GrandChildren gc=new GrandChildren(); //constructor from parent class
        gc.money(40); // money method from parent class 40
        gc.mobile();// Mobile method from child class
        gc.sms();//sms method from grandchildren class

        //Hierarchical Inheritance
        GrandChildren2 gc2=new GrandChildren2();//constructor from parent class
        gc2.mobile();//Mobile method from child class
        gc2.whatsApp();//whats app method from grandchildren 2
        gc2.useOfSuper();//40

    }

}
