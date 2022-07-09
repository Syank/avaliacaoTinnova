package tinnova;

import java.util.HashSet;
import java.util.Set;

public class MultiplesCalculator {

    public int calculateSum(int targetNumber) throws Exception {
        if (targetNumber < 0) {
            throw new Exception("Não é possível calcular os multiplos de um número negativo.");
        }

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
