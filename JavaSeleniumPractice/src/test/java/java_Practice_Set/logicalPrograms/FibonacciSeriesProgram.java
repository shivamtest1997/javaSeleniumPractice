package java_Practice_Set.logicalPrograms;

public class FibonacciSeriesProgram {
    public static void main(String[] args) {
        /**
         * fibonacci series starts with 0 and 1
         * each subsequent number is sum of the two preceding numbers
         * 0 1 1 2 3 5 8 13
         */
        int terms = 15; // number of terms in fibonacci series

        System.out.println("fibonacci series up to " + terms + " terms");
        // loop to generate fibonacci series
        int first = 0;
        int second = 1;
        for (int i = 1; i < +terms; i++) {
            System.out.println(first + "");

            // calculate next numbers
            int next = first + second;
            first = second;
            second = next;
        }

    }
}
