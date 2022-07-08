package tinnova.tests;

/**
 * An auxiliary class to help with the validation and calculation of votes, providing methods that can be used
 * to retrieve relative values for each context of vote
 *
 * @author Rafael Furtado
 */
public class VotesCalculator {
    private int totalVotes;
    private int validVotes;
    private int whiteVotes;
    private int nullVotes;

    /**
     * Initializes the class and validates if the given votes types are valid to be used by it
     *
     * @param totalVotes The total of votes registered
     * @param validVotes The total of valid votes
     * @param whiteVotes The total of white votes
     * @param nullVotes The total of null votes
     * @throws Exception If the sum of the valid, white and null votes isn't equals to the provided number of total votes,
     *                   an exception will be thrown to warn about a bad input
     * @author Rafael Furtado
     */
    public VotesCalculator(int totalVotes, int validVotes, int whiteVotes, int nullVotes) throws Exception {
        this.totalVotes = totalVotes;
        this.validVotes = validVotes;
        this.whiteVotes = whiteVotes;
        this.nullVotes = nullVotes;

        int realVotesQuantity = validVotes + whiteVotes + nullVotes;

        if (realVotesQuantity != totalVotes) {
            throw new Exception("A quantia de votos real é diferente da quantia total declarada.");
        }
    }

    /**
     * Calculates the relation between two given number
     *
     * @param x The integer to be divided by y
     * @param y The integer to divide x by
     * @return Returns a float that represents the relation between the two given numbers
     * @author Rafael Furtado
     */
    private float calculatePercentage(int x, int y) {
        float percentage = (float) x / y;

        return percentage;
    }

    /**
     * Calculates the percentage of white votes in reason of the total of votes
     *
     * @return Returns the percentage of white votes
     * @author Rafael Furtado
     */
    public float calculateWhiteVotesPercentage() {
        float whiteVotesPercentage = this.calculatePercentage(this.whiteVotes, this.totalVotes);

        return whiteVotesPercentage;
    }

    /**
     * Calculates the percentage of valid votes in reason of the total of votes
     *
     * @return Returns the percentage of valid votes
     * @author Rafael Furtado
     */
    public float calculateValidVotesPercentage() {
        float validVotesPercentage = this.calculatePercentage(this.validVotes, this.totalVotes);

        return validVotesPercentage;
    }

    /**
     * Calculates the percentage of null votes in reason of the total of votes
     *
     * @return Returns the percentage of null votes
     * @author Rafael Furtado
     */
    public float calculateNullVotesPercentage() {
        float nullVotesPercentage = this.calculatePercentage(this.nullVotes, this.totalVotes);

        return nullVotesPercentage;
    }

}
