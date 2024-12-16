package java_Practice_Set.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {

            List<String> vehicles = Arrays.asList("bus","car","bicycle","truck","train","plane");

            List<String> vehiclesInUpperCase=new ArrayList<>();

            // without streams
            for (String v:vehicles)
            {
                vehiclesInUpperCase.add(v.toUpperCase());
            }
              System.out.println(vehiclesInUpperCase);

            // By using stream

            vehiclesInUpperCase=vehicles.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
            System.out.println("using streams : "+vehiclesInUpperCase);

            vehicles.stream().map(name->name.toUpperCase()).forEach(s-> System.out.println(s));

            // example : Find length of every element and print it

            // without streams
       /*     for (String v:vehicles)
            {
                System.out.println(v.length());
            }
       */

            vehicles.stream().map(s->s.length()).forEach(i-> System.out.println(i));

            // Example :

            List<Integer> numbers=Arrays.asList(4,5,6,7,8,9);
            numbers.stream().map(n->n*3).forEach(result-> System.out.println(result));

    }
}
