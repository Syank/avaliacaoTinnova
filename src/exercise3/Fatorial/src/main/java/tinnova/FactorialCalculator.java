package tinnova;

public class FactorialCalculator {
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
