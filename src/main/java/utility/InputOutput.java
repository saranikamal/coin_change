package utility;

import java.util.*;

/**
 * @author Sara
 */
public class InputOutput {

    private Scanner scanner = new Scanner(System.in);
    /*I might need to close scanner in a graceful way*/
    private final Validator inputValidator = new InputValidator();
    private String validatedInput;

    public String getValidatedInput() {
        return validatedInput;
    }

    /**
     * @return Returns the value that user has entered in the terminal.
     */
    private String readLine() {
        System.out.println("Enter an amount:");
        return scanner.nextLine();
    }

    /**
     * @param input Input is the value that is entered by the user and needs to be validated.
     * @return Returns true if the value entered by the user is acceptable.
     */
    private boolean validateInput(String input) {
        return inputValidator.isInputValid(input);
    }

    /**
     * @param line Input entered by the user.
     * @return If the input is valid returns the input, otherwise for invalid inputs returns only zero.
     */
    public String validate(String line) {
        boolean valid = validateInput(line);
        if (valid) {
            return line;
        }
        return "0";
    }

    /**
     * @param validatedInput While the user input has been validated in might need some conversions from pound to pence
     *                       or from floating point to decimal etc. to finally have all values in pence.
     * @return Returns the processed and converted value in pence.
     */
    public int preProcessingInput(String validatedInput) {
        double numeric;
        int result;
        /*Removing pence sign*/
        if (validatedInput.charAt(validatedInput.length() - 1) == 'p')

            validatedInput = validatedInput.substring(0, validatedInput.length() - 1);
        /* Removing pound sign and converting its value to pence*/
        /* This line is equal to if(validatedInput.charAt(0) == '£'), to produce javadoc
         *  which did not recognize the '£' sign, the alternative way is used. */
        if (validatedInput.substring(0, validatedInput.length() - (validatedInput.length() - 1)).equals("£")) {
            validatedInput = validatedInput.substring(1, validatedInput.length());
            numeric = Double.parseDouble(validatedInput) * 100;
            result = (int) Math.round(Math.ceil(numeric));
            return result;
        }
        /*If input doesn't contain pound or p sign, but has floating point, convert it to pence*/
        if (validatedInput.contains(".")) {
            numeric = Double.parseDouble(validatedInput) * 100;
            result = (int) Math.round(Math.ceil(numeric));
            return result;
        }
        /*It is just in pence, doesn't need conversion*/
        result = Integer.parseInt(validatedInput);
        return result;

    }

    /**
     * This method gets the user input, calls for validation and pre-processing.
     *
     * @return Returns the processed user input that is ready to be denominated.
     */
    public int getInput() {
        String validatedInput;
        int pence;
        String line = readLine();
        validatedInput = validate(line);
        /* Keeping the validated input entered by user in validatedInput attribute to access it and display it later*/
        this.validatedInput = validatedInput;
        pence = preProcessingInput(validatedInput);
        return pence;
    }

    /**
     * @param minimumCoinsList The minimum number and types of coins we need for the denomination.
     * @param coinList         The list of the coins we have.
     * @return returns result of the denomination in the desired string format to show what types
     * of coins and how many of them we need.
     */
    private String postProcessingOutput(List<Integer> minimumCoinsList, int[] coinList) {
        String output = "";
        Map<Integer, Integer> coinMap = new HashMap<>();
        for (int coin : minimumCoinsList) {
            coinMap.put(coin, Collections.frequency(minimumCoinsList, coin));
        }

        for (int coin : coinList) {
            if (coinMap.containsKey(coin)) {
                if (coin >= 100)
                    output = String.format("%d x £%d, ", coinMap.get(coin), coin / 100) + output;
                else
                    output = String.format("%d x %dp, ", coinMap.get(coin), coin) + output;
            }
        }
        if (!output.isEmpty())
            output = output.substring(0, output.length() - 2);
        else output = "0";

        return output;
    }

    /**
     * @param minimumCoinList Minimum number of coins we need for the denomination.
     * @param coinList        List of the coins we have.
     */
    public void showOutput(List<Integer> minimumCoinList, int[] coinList) {
        String output = postProcessingOutput(minimumCoinList, coinList);
        System.out.print(getValidatedInput() + " = ");
        System.out.println(output);
    }
}
