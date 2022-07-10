package tinnova;

import java.util.Scanner;

/**
 * A helper class to provide static methods that can be used to easily read inputs from the user
 * 
 * @author Rafael Furtado
 */
public class InputReader {

    /**
     * Read the next input from the user as an integer
     * 
     * @return Returns the input integer provided from the user
     * @throws java.util.InputMismatchException If the user didn't provide a valid integer
     * @author Rafael Furtado
     */
    public static int readInt() {
        Scanner inputReader = new Scanner(System.in);

        int inputNumber = inputReader.nextInt();

        return inputNumber;
    }

    /**
     * Read the next input from the user as an integer, showing a text before the input
     *
     * @param complementaryText A text that will be output to the user before hims input
     * @return Returns the input integer provided from the user
     * @throws java.util.InputMismatchException If the user didn't provide a valid integer
     * @author Rafael Furtado
     */
    public static int readInt(String complementaryText) {
        System.out.println(complementaryText);

        return readInt();
    }

}
