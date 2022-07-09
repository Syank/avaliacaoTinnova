package tinnova;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialCalculatorTest {

    @Test
    public void assertCalculationIsCorrect() throws Exception {
        int factorialInput = 5;
        int factorialResult = 120;

        InputReaderTest.simulateUserIntInput(factorialInput);

        int factorial = InputReader.readInt();

        int result = FactorialCalculator.calculate(factorial);

        assertEquals(factorialResult, result);

        InputReaderTest.restoreSystemIn();

    }

    @Test(expected = Exception.class)
    public void assertExceptionIsThrowForNegativeFactorial() throws Exception {
        int factorialInput = -5;

        InputReaderTest.simulateUserIntInput(factorialInput);

        int factorial = InputReader.readInt();

        InputReaderTest.restoreSystemIn();

        FactorialCalculator.calculate(factorial);

    }

}
