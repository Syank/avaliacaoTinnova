package tinnova.tests;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Main {

    public static void main( String[] args ) {
        Integer[] array = {3, 5, -1, 0, 4, 10, 13, 7, 0, 3, 1, 2, 19, 21, 55, 30, 41, 60, 15, 87, 99, 0};

        BubbleSorter sorter = new BubbleSorter();

        sorter.sort(array);

        // Casts the default array into a List, in this way, the output of the print will be prettified
        System.out.println(new ArrayList<>(Arrays.asList(array)));

    }

}
