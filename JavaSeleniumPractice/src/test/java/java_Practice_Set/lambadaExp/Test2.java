package java_Practice_Set.lambadaExp;

@FunctionalInterface
interface Cab
{
    public void bookCab(String source,String destination);
}

class Ola implements Cab
{

    @Override
    public void bookCab(String source, String destination) {

        System.out.println("Ola cab is booked from "+source+" to "+destination);
    }
}


public class Test2 {
    public static void main(String[] args) {

        Cab cab=(source, destination)-> System.out.println("Ola Cab is booked from "+source+" to "+destination);
        cab.bookCab("wagholi", "Pimpri");
    }
}
