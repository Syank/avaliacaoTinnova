package tinnova;

import java.text.DecimalFormat;


public class Main {
    private static int TOTAL_VOTERS = 1000;
    private static int VALID_VOTES = 800;
    private static int WHITE_VOTES = 150;
    private static int NULL_VOTES = 50;



    public static void main(String[] args) throws Exception {
        VotesCalculator calculator = new VotesCalculator(TOTAL_VOTERS, VALID_VOTES, WHITE_VOTES, NULL_VOTES);

        float validVotesPercentage = calculator.calculateValidVotesPercentage() * 100;
        float whiteVotesPercentage = calculator.calculateWhiteVotesPercentage() * 100;
        float nullVotesPercentage = calculator.calculateNullVotesPercentage() * 100;

        DecimalFormat decimalFormatter = new DecimalFormat("###.##");

        System.out.println("Houve um total de \"" + TOTAL_VOTERS + "\" votos, dos quais,");
        System.out.println("\tos votos válidos foram \"" + VALID_VOTES + "\", representando " + decimalFormatter.format(validVotesPercentage) + "% do total,");
        System.out.println("\tos votos em branco foram \"" + WHITE_VOTES + "\", representando " + decimalFormatter.format(whiteVotesPercentage) + "% do total,");
        System.out.println("\tos votos nulos foram \"" + NULL_VOTES + "\", representando " + decimalFormatter.format(nullVotesPercentage) + "% do total.");

    }

}
