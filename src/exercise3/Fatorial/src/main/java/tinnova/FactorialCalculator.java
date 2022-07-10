package tinnova;


/**
 * An utilities class that provides a static method to calculate the factorial of a given number
 *
 * @author Rafael Furtado
 */
public class FactorialCalculator {

    /**
     * Calculates the factorial result of a given number
     *
     * @param factorial The number to calculate it's factorial
     * @return Returns the factorial of the provided number
     * @throws Exception If the given number is negative
     * @author Rafael Furtado
     */
    public static int calculate(int factorial) throws Exception {
        if (factorial < 0) {
            throw new Exception("Não é possível calcular o fatorial de um número menor do que 0.");
        }

        int result = 1;

        for (int i = 1; i <= factorial; i++) {
            result *= i;

        }

        return result;
    }

}
