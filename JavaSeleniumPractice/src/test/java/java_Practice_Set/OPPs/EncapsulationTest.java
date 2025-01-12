package java_Practice_Set.OPPs;

/**
 * 1.Encapsulation is one of the OOPs principle, and it refers to wrapping data(variable) and methods
 * together into a single unit.
 * 2.In simple terms, encapsulation is about protecting the internal state of an object from outside interference
 * and misuse by using access modifiers and providing controlled access through methods.
 * 3.In encapsulation variables of class are declared as private so hidden from all other classes and
 * can be access through its public getters and setters method so it is called as data hiding
 * Benefits of Encapsulation:
 *     Control: You can control how the data is accessed or modified.
 *     Security: By restricting direct access to variables, you will prevent unauthorized changes or misuse.
 *     Flexibility: You can change the internal implementation of the class without affecting external code.
 *     Maintainability: Easier to modify or debug the class because you can isolate changes to a specific area.
 */
class Person{
    //declare private variables(data hiding)
    private  int age;
    private String name;

    //getter for name
    public String getName()
    {
        return name;
    }
    //setter for name
    public void setName(String name)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        // You can include validation in the setter
        if (age > 0 && age < 18) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }
    public void  displayInformation()
    {
        System.out.println("name of person "+name);
        System.out.println("age of person "+age);
    }
}
public class EncapsulationTest {

    public static void main(String[] args) {
        //create object of person class
        Person p=new Person();

        p.setName("Shivam"); //set name of method
        p.setAge(50); //set age of name

        System.out.println("Name :"+p.getName());
        System.out.println("Age :"+p.getAge());

        //display full information
        p.displayInformation(); // Output: Name: Shivam, Age: 50

        // Attempt to set an invalid age
        p.setAge(150);  // Output: Invalid age.

    }
}
