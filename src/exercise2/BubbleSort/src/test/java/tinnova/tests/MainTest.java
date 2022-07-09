package tinnova.tests;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MainTest {

    @Test
    public void checkBubbleSorterCases() {
        Integer[] sampleArrayOne = {3, 2, 1};
        Integer[] sampleArrayTwo = {-1, -2, -3};
        Integer[] sampleArrayThree = {3, 2, 1, 0, -1, -2, -3};
        Integer[] sampleArrayFour = {3, 5, -1, 0, 4, 10, 13, 7, 0, 3, 1, 2, 19, 21, 55, 30, 41, 60, 15, 87, 99, 0};

        Integer[] sortedArrayOne = {1, 2, 3};
        Integer[] sortedArrayTwo = {-3, -2, -1};
        Integer[] sortedArrayThree = {-3, -2, -1, 0, 1, 2, 3};
        Integer[] sortedArrayFour = {-1, 0, 0, 0, 1, 2, 3, 3, 4, 5, 7, 10, 13, 15, 19, 21, 30, 41, 55, 60, 87, 99};

        BubbleSorter sorter = new BubbleSorter();

        sorter.sort(sampleArrayOne);
        sorter.sort(sampleArrayTwo);
        sorter.sort(sampleArrayThree);
        sorter.sort(sampleArrayFour);

        assertArrayEquals(sampleArrayOne, sortedArrayOne);
        assertArrayEquals(sampleArrayTwo, sortedArrayTwo);
        assertArrayEquals(sampleArrayThree, sortedArrayThree);
        assertArrayEquals(sampleArrayFour, sortedArrayFour);

    }

}
