package tinnova;

import java.util.HashSet;
import java.util.Set;


/**
 * An utilities class that provide methods to calculate the sum of 3 and 5 multiples
 *
 * @author Rafael Furtado
 */
public class MultiplesCalculator {

    /**
     * Calculates the sum of multiples of 3 or 5 below the given target number
     *
     * If the target number is a multiple of 3 or 5, it won't be included in sum
     *
     * @param targetNumber The target number to calculate the sum of the multiples of 3 or 5
     * @return Returns the sum result of the multiples of 3 or 5 below the target number
     * @throws Exception If the provided target number is negative
     * @author Rafael Furtado
     */
    public int calculateSum(int targetNumber) throws Exception {
        if (targetNumber < 0) {
            throw new Exception("Não é possível calcular os multiplos de um número negativo.");
        }

        // A set is used here to ensure that numbers that are multiple of 3 and 5 won't be sum two times
        Set<Integer> multiples = new HashSet<Integer>();

        for (int i = 1; i <= targetNumber; i++) {
            if (i * 3 < targetNumber) {
                multiples.add(i * 3);

            }

            if (i * 5 < targetNumber) {
                multiples.add(i * 5);

            }

        }

        int sum = 0;

        for (int multiple: multiples) {
            sum += multiple;

        }

        return sum;
    }

}
