package tinnova;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;


/**
 *
 */
public class MainTest {

    @Test(expected = Exception.class)
    public void assertInvalidArgumentsInConstructor() throws Exception {
        int totalVotes = 500;
        int validVotes = 10;
        int whiteVotes = 10;
        int nullVotes = 10;

        new VotesCalculator(totalVotes, validVotes, whiteVotes, nullVotes);

    }

    @Test
    public void assertCorrectCalculations() throws Exception {
        int totalVotes = 100;
        int validVotes = 60;
        int whiteVotes = 30;
        int nullVotes = 10;

        VotesCalculator calculator = new VotesCalculator(totalVotes, validVotes, whiteVotes, nullVotes);

        float validVotesPercentage = calculator.calculateValidVotesPercentage();
        float whiteVotesPercentage = calculator.calculateWhiteVotesPercentage();
        float nullVotesPercentage = calculator.calculateNullVotesPercentage();

        DecimalFormat decimalFormatter = new DecimalFormat("#.#");

        // Since the formatter didn't change the numbers and just round it, the bellow assertions are valid
        assertEquals(decimalFormatter.format(validVotesPercentage), "0,6");
        assertEquals(decimalFormatter.format(whiteVotesPercentage), "0,3");
        assertEquals(decimalFormatter.format(nullVotesPercentage), "0,1");

    }

}
