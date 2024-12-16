package java_Practice_Set.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods {
    public static void main(String[] args) {

        // distinct() limit()
        //count

        // to find unique object from collection

        List<String> vehicles = Arrays.asList("bus", "car", "bicycle", "plane", "car", "train", "bus", "truck");

        List<String> distinctList = vehicles.stream().distinct().collect(Collectors.toList());

        System.out.println(distinctList);

        vehicles.stream().distinct().forEach(System.out::println);

        //count
        long count = vehicles.stream().distinct().count();
        System.out.println(count);

        //limit()
        List<String> limitedVehicles = vehicles.stream().limit(3).collect(Collectors.toList());
        System.out.println(limitedVehicles);

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //limit
        List<Integer> l = numList.stream().distinct().limit(2).collect(Collectors.toList());
        System.out.println("limit : " + l);
        //count
        long evenNoCount = numList.stream().filter(num -> num % 2 == 0)
                .count();
        System.out.println(evenNoCount);
        //min and max
        Optional<Integer> minimum = numList.stream().min((val1, val2) -> val1.compareTo(val2));
        System.out.println(minimum.get());
        Optional<Integer> maximum = numList.stream().max((val1, val2) -> val1.compareTo(val2));
        System.out.println(maximum.get());


        // reduce

        List<String> stringList = Arrays.asList("A", "B", "C", "2", "3", "7", "9");

        Optional<String> red = stringList.stream().reduce((value, combineValue) ->
                {
                    return value + combineValue; // A+B+C
                }
        );
        System.out.println(red.get());


        // Sorted

        List<Integer> numbers = Arrays.asList(4, 5, 7, 8, 1, 2, 6, 4, 9);

        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        List<Integer> sortedListReverse = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedListReverse);

        // anyMatch() , allMatch() , noneMatch()

        Set<String> fruites = new HashSet<String>();
        fruites.add("grapes");
        fruites.add("mango");
        fruites.add("banana");
        fruites.add("apple");

        boolean result=fruites.stream().anyMatch(value -> {
                                                return value.startsWith("g");
                                            });
        System.out.println(result); //true

        boolean result1=fruites.stream().allMatch(value -> {
            return value.startsWith("g");
        });

        System.out.println(result1);  // false


        boolean result3=fruites.stream().noneMatch(value -> {
            return value.startsWith("p");
        });

        System.out.println(result3);  // true

        // findAny and findFirst

        Optional<String> str=fruites.stream().findAny();

        System.out.println(str.get());

        Optional<String> str1=fruites.stream().findFirst();

        System.out.println(str1.get());

    }
}