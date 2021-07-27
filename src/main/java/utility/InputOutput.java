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
        String validatedInput;
        int pence;
        String line = readLine();
        validatedInput = validate(line);
        pence = preProcessingInput(validatedInput);
        System.out.println("pence = " + pence);
        return pence;
    }

    private int preProcessingInput(String validatedInput) {
        double numeric;
        int result;

        if (validatedInput.charAt(validatedInput.length() - 1) == 'p')
            /*Removing pence sign*/
            validatedInput = validatedInput.substring(0, validatedInput.length() - 1);
        /*Removing pound sign*/
        if (validatedInput.charAt(0) == '£') {
            validatedInput = validatedInput.substring(1);
            numeric = Double.parseDouble(validatedInput) * 100;
            result = (int) Math.round(Math.ceil(numeric));
            return result;
        }

        if (validatedInput.contains(".")) {
            numeric = Double.parseDouble(validatedInput) * 100;
            result = (int) Math.round(Math.ceil(numeric));
            return result;
        }

        /* It is just in pence */
        result = Integer.parseInt(validatedInput);
        return result;

    }
}
