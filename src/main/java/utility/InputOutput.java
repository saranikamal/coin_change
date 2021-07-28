package utility;

import java.util.*;

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
            return line;
        }
        return "0";
    }

    public int preProcessingInput(String validatedInput) {
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

    public int getInput() {
        String validatedInput;
        int pence;
        String line = readLine();
        validatedInput = validate(line);
        pence = preProcessingInput(validatedInput);
        return pence;
    }

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
        if(!output.isEmpty())
            output = output.substring(0, output.length() - 2);
        else output = "0";

        return output;
    }

    public void showOutput(List<Integer> minimumCoinList, int[] coinList) {
        String output = postProcessingOutput(minimumCoinList, coinList);
        System.out.println(output);
    }
}
