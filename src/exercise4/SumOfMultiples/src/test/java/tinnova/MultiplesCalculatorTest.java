package tinnova;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplesCalculatorTest {

    @Test(expected = Exception.class)
    public void assertExceptionIsThrowForNegativeNumber() throws Exception {
        int targetNumberInput = -10;

        InputReaderTest.simulateUserIntInput(targetNumberInput);

        int targetNumber = InputReader.readInt();

        MultiplesCalculator calculator = new MultiplesCalculator();

        InputReaderTest.restoreSystemIn();

        calculator.calculateSum(targetNumber);

    }

    @Test
    public void assertCorrectMultiplesCalculation() throws Exception {
        int targetNumberInput = 10;
        int expectedResult = 23;

        InputReaderTest.simulateUserIntInput(targetNumberInput);

        int targetNumber = InputReader.readInt();

        MultiplesCalculator calculator = new MultiplesCalculator();

        int sum = calculator.calculateSum(targetNumber);

        InputReaderTest.restoreSystemIn();

        assertEquals(sum, expectedResult);

    }

}
