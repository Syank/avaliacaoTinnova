package tinnova.tests;

/**
 * An utilities class that offers a single method that can be used to sort an array of integers using
 * the bubble sort algorithm
 *
 * @author Rafael Furtado
 */
public class BubbleSorter {

    /**
     * Sorts, inline, the given array using the algorithm
     *
     * @param arrayToSort The array to be sorted
     * @author Rafael Furtado
     */
    public void sort(Integer[] arrayToSort) {
        int iterations = arrayToSort.length - 1;

        if (iterations > 0) {
            iterate(arrayToSort, iterations);

        }
    }

    /**
     * Performs an iteration over the array using the algorithm
     *
     * @param arrayToSort The array to be sorted
     * @param iterationsLeft The amount of iterations that are left to be done over the array
     * @author Rafael Furtado
     */
    private void iterate(Integer[] arrayToSort, int iterationsLeft) {
        if (iterationsLeft > 0) {
            bubble(arrayToSort, iterationsLeft);

            iterate(arrayToSort, iterationsLeft - 1);

        }

    }

    /**
     * Applies the bubble sort algorithm over the given array
     *
     * @param arrayToSort The array to be sorted
     * @param indexLimit The maximum range of index in the array that the algorithm can access
     * @author Rafael Furtado
     */
    private void bubble(Integer[] arrayToSort, int indexLimit) {
        for (int i = 0; i < indexLimit; i++) {
            int currentNumber = arrayToSort[i];

            if (i < indexLimit){
                int nextNumber = arrayToSort[i + 1];

                if (currentNumber > nextNumber) {
                    swapValues(arrayToSort, i, i + 1);

                }

            }

        }

    }

    /**
     * Swaps two values in the given positions in the array
     *
     * @param array The array to have the values swapped
     * @param firstIndex The index of the first item to be swapped
     * @param secondIndex The index of the second item to be swapped
     * @author Rafael Furtado
     */
    private void swapValues(Integer[] array, int firstIndex, int secondIndex) {
        int storedValue = array[firstIndex];

        array[firstIndex] = array[secondIndex];
        array[secondIndex] = storedValue;

    }

}
