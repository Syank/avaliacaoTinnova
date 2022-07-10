package tinnova;



public class Main {

    public static void main(String[] args) throws Exception {
        int targetNumber = InputReader.readInt("Digite o número alvo para calcular a soma dos multiplos de 3 ou 5 abaixo dele: ");

        MultiplesCalculator calculator = new MultiplesCalculator();

        int sum = calculator.calculateSum(targetNumber);

        System.out.println("A soma dos multiplos de 3 ou 5 abaixo de " + targetNumber + " é: " + sum);

    }

}
