package tinnova.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import java.text.DecimalFormat;


/**
 *
 */
public class MainTest {

    @Test
    public void assertInvalidArgumentsInConstructor() {
        int totalVotes = 500;
        int validVotes = 10;
        int whiteVotes = 10;
        int nullVotes = 10;

        assertThrows(Exception.class, () -> new VotesCalculator(totalVotes, validVotes, whiteVotes, nullVotes));

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
