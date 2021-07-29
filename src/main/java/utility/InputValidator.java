package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sara
 */
public class InputValidator implements Validator {
    /**
     *
     * @param input The input user enters.
     * @return returns true if the input submits to the allowed pattern:
     *                     numeric, pence and pound symbols and floating point in the correct position in the string.
     */
    @Override
    public boolean isInputValid(String input){
        boolean result;
        String regex = "^[£]?[0-9]*\\.?[0-9]+[p]?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        result = matcher.matches();
        return result;
    }
}
