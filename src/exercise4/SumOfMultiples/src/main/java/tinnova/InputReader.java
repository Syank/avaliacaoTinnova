package tinnova;

import java.util.Scanner;

public class InputReader {
    public static int readInt() {
        Scanner inputReader = new Scanner(System.in);

        int inputNumber = inputReader.nextInt();

        return inputNumber;
    }

    public static int readInt(String complementaryText) {
        System.out.println(complementaryText);

        return readInt();
    }

}
