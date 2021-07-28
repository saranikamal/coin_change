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
        System.out.println("zero");
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
        /*Removing pound sign and converting its value to pence*/
        if (validatedInput.charAt(0) == '£') {
            validatedInput = validatedInput.substring(1, validatedInput.length());
            numeric = Double.parseDouble(validatedInput) * 100;
            result = (int) Math.round(Math.ceil(numeric));
            return result;
        }
        /* If it doesn't contain pound or p sign, but is decimal, convert it to pence*/
        if (validatedInput.contains(".")) {
            numeric = Double.parseDouble(validatedInput) * 100;
            result = (int) Math.round(Math.ceil(numeric));
            return result;
        }

        /* It is just in pence, doesn't need conversion */
        result = Integer.parseInt(validatedInput);
        return result;

    }
}
