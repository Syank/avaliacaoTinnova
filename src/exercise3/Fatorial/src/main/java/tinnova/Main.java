package tinnova;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int factorial = InputReader.readInt("Digite um número  maior ou igual a 0 para calcular o seu fatorial: ");

        int result = FactorialCalculator.calculate(factorial);

        System.out.println("O fatorial de " + factorial + " é " + result + ".");

    }

}
