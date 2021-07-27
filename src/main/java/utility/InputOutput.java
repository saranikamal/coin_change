package utility;

import java.util.Scanner;

public class InputOutput {

    private Scanner scanner = new Scanner(System.in);
    private Validator inputValidator = new InputValidator();

    /*I have to close scanner in a graceful way*/

    private String readLine() {
        System.out.println("Enter an amount:");
        return scanner.nextLine();
    }

    private boolean validateInput(String input) {
        return inputValidator.isInputValid(input);
    }

    public String validate(String line) {
        boolean valid = validateInput(line);
        if (valid) {
            System.out.println("line = " + line);
            return line;
        }
        System.out.println("Sefr");
        return "0";
    }

    public int getInput() {
        String line = readLine();
        validate(line);
        return 2;//Integer.parseInt(validate(line));
    }
}
