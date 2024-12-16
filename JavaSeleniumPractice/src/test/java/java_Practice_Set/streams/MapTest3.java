package java_Practice_Set.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MapTest3 {
    public static void main(String[] args) {

        List<Integer> numbers= Arrays.asList(1,5,6,8,10,12,9,14,64,2);

        //Predicate to filter even numbers

        Predicate<Integer> isEven=num->num%2==0;

        // Function to square a number

        Function<Integer,Integer> squareFunc=num->num*num;

        // consumer to print each squared number

        Consumer<Integer> printNo= System.out::println;

        // supplier to count total squared numbers

        Supplier<Integer> countSupplier=()->0;

        numbers.stream().filter(isEven)  // filter even number
                .map(squareFunc) // map each number to square
                .forEach(s-> System.out.println(s));

    }
}
