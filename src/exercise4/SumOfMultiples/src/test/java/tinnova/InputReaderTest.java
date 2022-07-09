package tinnova;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {
    private static final InputStream SYSTEM_IN = System.in;

    @Test(expected = InputMismatchException.class)
    public void expectExceptionIfNotInt() {
        simulateUserInput("not an integer");

        InputReader.readInt();

        restoreSystemIn();

    }

    @Test
    public void expectEqualsInput() {
        int valueToInput = 5;

        simulateUserIntInput(valueToInput);

        int readInput = InputReader.readInt();

        assertEquals(valueToInput, readInput);

        restoreSystemIn();

    }

    public static void simulateUserIntInput(int inputValue) {
        String stringInputValue = String.valueOf(inputValue);

        simulateUserInput(stringInputValue);

    }

    public static void simulateUserInput(String inputValue) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputValue.getBytes());

        System.setIn(inputStream);

    }

    public static void restoreSystemIn() {
        System.setIn(SYSTEM_IN);

    }

}
