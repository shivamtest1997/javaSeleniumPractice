package java_Practice_Set.lambadaExp;

@FunctionalInterface
interface Uber{

    public String bookCab(String source,String destination);

}

public class Test3 {

    public static void main(String[] args) {

        Uber ub=(source, destination) ->
        {

            System.out.println("Uber is booked from "+source+" and reached to "+destination);
            return ("Price of Rs 500");
        };

        System.out.println(ub.bookCab("NashikPhata", "Pune Station"));
    }

}
