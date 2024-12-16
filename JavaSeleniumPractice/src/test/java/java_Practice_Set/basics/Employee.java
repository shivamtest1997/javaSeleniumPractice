package java_Practice_Set.basics;

class Cellphone{

    public void callFriend()
    {
        System.out.println("Calling friend");
    }
    public void ring()
    {
        System.out.println("Ringing.....");
    }
    public void vibrate()
    {
        System.out.println("vibrating.....");
    }
}

class Square{
    int side;
    public int area()
    {
        return side*side;
    }
    public int perimeter()
    {
        return 4*side;
    }

}

public class Employee {

    int salary;
    String name;
    public int getSalary()
    {
        return salary;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name=n;
    }

    public static void main(String[] args) {
        Employee emp1=new Employee();
        emp1.setName("Shivam");
        emp1.salary=35;
        System.out.println(emp1.getName());
        System.out.println(emp1.getSalary());


        // Cellphone objects
        Cellphone vivo=new Cellphone();
        vivo.callFriend();
        vivo.ring();
        vivo.vibrate();
        Cellphone asus=new Cellphone();
        asus.callFriend();
        asus.ring();
        asus.vibrate();

        //square objects
        Square sq=new Square();
        sq.side=10;
        System.out.println("Area of square is "+ sq.area());
        System.out.println("perimeter of square is " +sq.perimeter());

    }



}
