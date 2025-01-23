package java_Practice_Set.basics;

public class Variables {

    /**
     * Def:
     * A variable is a container which holds the value while the Java program is executed.
     * A variable is assigned with a data type.
     * Variable is a name of memory location. There are three types of variables in java: local, instance and static.
     * A variable is the name of a reserved area allocated in memory. In other words, it is a name of the memory location.
     * It is a combination of "vary + able" which means its value can be changed.
     */
    /*
      1) Local Variable

      A variable declared inside the body of the method is called local variable.
      You can use this variable only within that method and the other methods in the class aren't even aware that the variable exists.

      A local variable cannot be defined with "static" keyword.
     */

    public static void m1()
    {
        //defining a Local Variable
        int num = 10;
        System.out.println(" Variable: " + num); //10
    }
    /**
     * 2) Instance Variable
     *
     * A variable declared inside the class but outside the body of the method, is called an instance variable.
     * It is not declared as static.
     *
     * It is called an instance variable because its value is instance-specific and is not shared among instances.
     */
        //Defining Instance Variables
        public String name;
        public int age=19;
        //Creadting a default Constructor initializing Instance Variable
        public Variables()
        {
            this.name = "Deepak";
        }

     /*
     3) Static variable

        A variable that is declared as static is called a static variable.
        It cannot be local.
        You can create a single copy of the static variable and share it among all the instances of the class.
        Memory allocation for static variables happens only once when the class is loaded in the memory.

      */
    static int personAge;


    public static void main(String[] args) {

            Variables var=new Variables();
            System.out.println("Student Name is: " + var.name);
            System.out.println("Age: "+ var.age);

            Variables s1=new Variables();
            s1.personAge = 24;
            Variables s2=new Variables();

            s2.personAge = 21;
            Variables.personAge=23;
            System.out.println("S1\'s age is: " + s1.personAge); //S1's age is: 23
            System.out.println("S2\'s age is: " + s2.personAge); //S2's age is: 23


            //Java Variable Example: Widening
            int a=10;
            float f=a;
            System.out.println(a); //10
            System.out.println(f); //10.0

            //Java Variable Example: Narrowing (Typecasting)
            float ff=10.5f;
            //int a=f;//Compile time error
            int aa=(int)ff;
            System.out.println(ff); //10.5
            System.out.println(aa); //10

            //Java Variable Example: Overflow
            //Overflow
            int p=130;
            byte q=(byte)p;
            System.out.println(p);  //130
            System.out.println(q);  //126
    }
}
